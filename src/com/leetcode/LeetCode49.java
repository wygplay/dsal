package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <a href="https://leetcode.cn/problems/group-anagrams">...</a>
 * 解题的关键在于key的生成算法
 */
public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // compute every string key
        // using map to store same-key string list
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = computeKey(str);
            //放入到map中
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public String computeKey(String str) {
        int[] numBits = new int[26];
        for (int i = 0; i < str.length(); i++) {
            numBits[str.charAt(i) - 'a']++;
        }
        // key的计算规则
        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0; i < numBits.length; i++) {
            if (numBits[i] > 0) {
                keyBuilder.append((char) ('a' + i));
                keyBuilder.append(numBits[i]);
            }
        }
        return keyBuilder.toString();
    }
}
