package com.questions;

import java.util.*;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/6/8 22:19
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() > 4) {
            throw new IllegalArgumentException("the length of input str exceeds the limit!!!");
        }
        List<String> letters = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<>();
        String str = "abcdefghijklmnopqrstuvwxyz";
        int index = 0;
        for (int i = 2; i < 10; i++) {
            int endIndex = index + 3;
            List<String> l = new ArrayList<>();
            if (i == 7) {
                endIndex = index + 4;
            }
            for (int j = index; j < endIndex; j++) {
                l.add(str.substring(j, j + 1));
            }
            map.put(String.valueOf(i), l);
            index = endIndex;
        }
        return null;
    }

    public void recursive(Stack<String> stack, List<String> letters, String digits) {

    }
}
