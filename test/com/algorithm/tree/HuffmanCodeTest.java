package com.algorithm.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

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
        huffmanCodes = HuffmanCode.generateHuffmanCode(str);
        huffmanCodeByte = HuffmanCode.encode(str, huffmanCodes);
        /*for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }*/
    }

    @Test
    public void encode() {
        HuffmanCode.encode(str, huffmanCodes);
    }

    @Test
    public void decode() {
        HuffmanCode.decode(huffmanCodeByte, huffmanCodes);
    }
    @Test
    public void test() {
        byte a = -88;
        System.out.println(Integer.toBinaryString(a));
    }

    @Test
    public void byeTest() {
        byte i = 35;
        i |= 256;
        System.out.println(Integer.toBinaryString(i));
    }
}