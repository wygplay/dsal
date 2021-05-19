package com.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.io.File;
import static org.junit.Assert.*;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/5/15 19:15
 */
public class HuffmanCodeTest {
    public Map<Byte, String> huffmanCodes;
    public String str;
    public byte[] huffmanCodeByte;
    @Before
    public void init() {
        str = "I know that after my death a pile of rubbish will be heaped on my grave, but the wind of History will sooner or later sweep it away without mercy";
        huffmanCodes = HuffmanCode.generateHuffmanCode(str.getBytes());
        huffmanCodeByte = HuffmanCode.encode(str.getBytes(), huffmanCodes);
        /*for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }*/
    }

    @Test
    public void encode() {
        byte[] bytes = HuffmanCode.encode(str.getBytes(), huffmanCodes);
        System.out.println(str.getBytes().length - bytes.length);
    }

    @Test
    public void decode() {
        byte[] bytes = HuffmanCode.decode(huffmanCodeByte, huffmanCodes);
        System.out.println(new String(bytes));
    }

    @Test
    public void encodeFile() {
        //图片压缩不太成功，重复字节太少的缘故
        File srcFile = new File("E:\\wallpaper\\backiee\\backiee-50757.jpg");
        File dstFile = new File("E:\\wallpaper\\backiee\\file.zip");
        HuffmanCode.encode(srcFile, dstFile);

        File decodedFile = new File("E:\\wallpaper\\backiee\\decoded.jpg");
        File zipFile = new File("E:\\wallpaper\\backiee\\file.zip");
        HuffmanCode.decode(zipFile, decodedFile);
    }

    @Test
    public void encodeFile2() {
        File srcFile = new File("C:\\Users\\WYG\\Desktop\\test.txt");
        File dstFile = new File("C:\\Users\\WYG\\Desktop\\file.zip");
        HuffmanCode.encode(srcFile, dstFile);

        File decodedFile = new File("C:\\Users\\WYG\\Desktop\\decoded.txt");
        File zipFile = new File("C:\\Users\\WYG\\Desktop\\file.zip");
        HuffmanCode.decode(zipFile, decodedFile);
    }

    @Test
    public void encodeFile3() {
        File srcFile = new File("C:\\Users\\WYG\\Desktop\\test.png");
        File dstFile = new File("C:\\Users\\WYG\\Desktop\\png.zip");
        HuffmanCode.encode(srcFile, dstFile);

        File decodedFile = new File("C:\\Users\\WYG\\Desktop\\decoded.png");
        File zipFile = new File("C:\\Users\\WYG\\Desktop\\png.zip");
        HuffmanCode.decode(zipFile, decodedFile);
    }
}