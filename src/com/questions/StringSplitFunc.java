package com.questions;

public class StringSplitFunc {
    public static int func(String input) {
        // 遍历字符串
        // 子字符串的计数 Y X 出现次数，xCount,yCount
        // 如果 xCount == yCount then 计算乘积  and xCount = yCount = 0
        // 重复第二步
        if (input == null || input.length() == 0) {
            return 0;
        }
        int result = 1;
        int yCount = 0;
        int xCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'X') {
                xCount++;
            } else {
                yCount++;
            }
            if (xCount * yCount > 0 && xCount == yCount) {
                result *= 2 * xCount;
                yCount = xCount = 0;
            }
        }
        return result;
    }
}
