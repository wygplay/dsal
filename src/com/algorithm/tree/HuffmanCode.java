package com.algorithm.tree;

import java.io.*;
import java.util.*;

/**
 * 根据字符串创建赫夫曼编码表
 * 将字符串按照赫夫曼码进行编码
 * @author wyg
 * @version 1.0
 * @date 2021/5/15 16:37
 */
public class HuffmanCode {
    static int complementLength = 0;
    //统计字符串中字符出现次数，并放到集合中
    private static List<HuffmanCodeNode> compute(byte[] bytes) {
        Map<Byte, Integer> map = new HashMap<>();
        List<HuffmanCodeNode> list = new ArrayList<>();
        for (int i = 0; i < bytes.length; i++) {
            if (map.get(bytes[i]) == null) {
                map.put(bytes[i], 1);
            } else {
                map.put(bytes[i], map.get(bytes[i]) + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new HuffmanCodeNode(entry.getKey(), entry.getValue()));
        }
        return list;
    }
    /**
     * 根据字符权重集合生成赫夫曼树
     */
    private static HuffmanCodeNode createHuffmanTreeCode(List<HuffmanCodeNode> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            HuffmanCodeNode left = list.get(0);
            HuffmanCodeNode right = list.get(1);
            HuffmanCodeNode parent = new HuffmanCodeNode(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        return list.get(0);
    }

    public static Map<Byte, String> generateHuffmanCode(byte[] bytes) {
        Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
        List<HuffmanCodeNode> list = compute(bytes);
        HuffmanCodeNode huffmanTreeRoot = createHuffmanTreeCode(list);
        if (huffmanTreeRoot == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        getHuffmanCode(huffmanCodes, huffmanTreeRoot.left, "0", sb);
        getHuffmanCode(huffmanCodes, huffmanTreeRoot.right, "1", sb);
        return huffmanCodes;
    }

    public static void getHuffmanCode(Map<Byte, String> huffmanCodes, HuffmanCodeNode node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node.data == null) {
            if (node.left != null) {
                getHuffmanCode(huffmanCodes, node.left, "0", stringBuilder2);
            }
            if (node.right != null) {
                getHuffmanCode(huffmanCodes, node.right, "1", stringBuilder2);
            }
        } else {
            huffmanCodes.put(node.data, stringBuilder2.toString());
        }
    }

    /**
     * 根据赫夫曼编码进行编码
     * @param str
     * @param huffmanCodes
     */
    public static byte[] encode(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(huffmanCodes.get(bytes[i]));
        }
        String huffmanCode = sb.toString();
        int length = huffmanCode.length() % 8 == 0 ? huffmanCode.length() / 8 : huffmanCode.length() / 8 + 1;
        byte[] huffmanCodeBytes = new byte[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (index + 8 < huffmanCode.length()) {
                huffmanCodeBytes[i] = (byte)Integer.parseInt(huffmanCode.substring(index, index + 8), 2);
            } else {
                String endCode = huffmanCode.substring(index);
                if (endCode.startsWith("0")) {
                    complementLength = endCode.length();
                }
                huffmanCodeBytes[i] = (byte)Integer.parseInt(endCode, 2);

                System.out.println("last: " + huffmanCode.substring(index));
            }
            index += 8;
        }
        return huffmanCodeBytes;
    }

    public static byte[] decode(byte[] huffmanCodeBytes, Map<Byte, String> huffmanCodes) {
        // 字节转为哈夫曼编码
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < huffmanCodeBytes.length; i++) {
            boolean isEnd = i == huffmanCodeBytes.length - 1;
            sb.append(byteToBitString(isEnd, huffmanCodeBytes[i]));
        }
        String huffmanCodeStr = sb.toString();
        // 哈夫曼key value反转
        Map<String, Byte> map = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        // 哈夫曼编码解码
        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < huffmanCodeStr.length();) {
            int count = 0;
            Byte decodedByte = null;
            while (decodedByte == null) {
                count++;
                if(i + count < huffmanCodeStr.length()) {
                    decodedByte = map.get(huffmanCodeStr.substring(i, i + count));
                } else {
                    decodedByte = map.get(huffmanCodeStr.substring(i));
                }
            }
            list.add(decodedByte);
            i += count;
        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bytes[i] = list.get(i);
        }
        return bytes;
    }

    /**
     * 哈夫曼编码压缩文件
     * @param srcFile
     * @param dstFile
     */
    public static void encode(File srcFile, File dstFile) {
        FileInputStream fileInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            Map<Byte, String> huffmanCodes = generateHuffmanCode(bytes);
            byte[] huffmanByteCodes = encode(bytes, huffmanCodes);
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(dstFile));
            objectOutputStream.writeObject(huffmanByteCodes);
            objectOutputStream.writeObject(huffmanCodes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 文件解压操作
     * @param zipFile
     */
    public static void decode(File zipFile, File decodedFile) {
        FileOutputStream fos = null;
        ObjectInputStream objs = null;
        try{
            fos = new FileOutputStream(decodedFile);
            objs = new ObjectInputStream(new FileInputStream(zipFile));
            byte[] huffmanBytes = (byte[]) objs.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) objs.readObject();
            byte[] bytes = decode(huffmanBytes, huffmanCodes);
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                objs.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String byteToBitString(boolean isEnd,int  b) {
        //考虑是否补码，正数需要补码，最后一个字节不确定是否补码，负数无所谓，补码与否对结果无影响
        //补码截取低八位
        if(!isEnd || complementLength != 0) {
            b |= 256;
        }
        String binaryStr = Integer.toBinaryString(b);
        if(!isEnd) {
            binaryStr = binaryStr.substring(binaryStr.length() - 8);
        } else if (isEnd && complementLength != 0){
            binaryStr = binaryStr.substring(binaryStr.length() - complementLength);
        }
        return binaryStr;
    }

}

class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {
    /**
     * 字符
     */
    public Byte data;
    /**
     * 权重
     */
    public int weight;

    public HuffmanCodeNode left;
    public HuffmanCodeNode right;

    public HuffmanCodeNode(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return this.weight - o.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HuffmanCodeNode that = (HuffmanCodeNode) o;
        return data.equals(that.data) && weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, weight);
    }


}