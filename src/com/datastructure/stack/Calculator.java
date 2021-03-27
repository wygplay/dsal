package com.datastructure.stack;

import com.sun.istack.internal.NotNull;

import java.util.Scanner;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/3/26 22:02
 * 计算器简单实现，非逆波兰法，个位数加减
 * 基础信息：运算符存在优先级，优先级高的先计算
 * 实现：
 * 将表达式读取到两个栈中，一个数栈，一个符号栈；
 * 1、遇见数字直接存入数栈中
 * 2、遇到如果符号大于栈顶符号那么将新符号存入符号栈中
 * 3、若新符号优先级小于或等于栈中符号，则取出栈中符号，取出两个数字进行计算，新符号入栈
 * 4、表达式读取完毕后，取出栈顶元素，进行最后的计算
 */
public class Calculator {
    static ArrayIntStack numberStack = new ArrayIntStack(20);
    /**
     * 可以使用ArrayIntStack，char和int可以互转；
     */
    static ArrayStack signStack = new ArrayStack(20);
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表达式：");
        String line = scanner.nextLine();
        System.out.println(calculate(line));
        numberStack.show();
        signStack.show();
        scanner.close();
    }

    public static boolean isSign(@NotNull char e) {
        String s = String.valueOf(e);
        if("*".equals(s) || "+".equals(s) || "-".equals(s) || "(".equals(s) || ")".equals(s)) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(@NotNull char e) {
        return Character.isDigit(e);
    }

    public static int calculate(String expression) {
        int total = 0;
        for(int i = 0; expression.length() > i; i++) {
            char c = expression.charAt(i);
            String s = String.valueOf(c);
            if (" ".equals(s)) {
                continue;
            }else if (isNumber(c)) {
                //使用
                int num = c - 48;
                numberStack.push(num);
            }else if (isSign(c)) {
                if (signStack.isEmpty()) {
                    signStack.push(s);
                    continue;
                }
                if (!compareSignPriority(s, signStack.getTop())) {
                    String sign = signStack.pop();
                    int numTwo = numberStack.pop();
                    int numOne= numberStack.pop();
                    numberStack.push(compute(numOne, numTwo, sign));
                    signStack.push(s);
                }
                signStack.push(s);

            }else if ("=".equals(s)) {
                String sign = signStack.pop();
                int numTwo = numberStack.pop();
                int numOne= numberStack.pop();
                total = compute(numOne, numTwo, sign);
            } else {
                throw new RuntimeException("输入不合法");
            }

        }
        return total;
    }

    public static boolean compareSignPriority(String signA, String signB) {
        return getSignCode(signA) > getSignCode(signB);
    }

    public static int compute(int numOne, int numTwo, String sign) {
        int total = 0;
        switch (sign) {
            case "+":
                total = numOne + numTwo;
                break;
            case "-":
                total = numOne - numTwo;
                break;
            case "*":
                total = numOne * numTwo;
                break;
            case "(":
                throw new IllegalArgumentException("暂不支持括号");
        }
        return total;
    }

    public static int getSignCode(String sign) {
        int code = 0;
        if("+".equals(sign) || "-".equals(sign)) {
            code = 1;
        } else if ("*".equals(sign)) {
            code = 2;
        } else if ("(".equals(sign) || ")".equals(sign)) {
            code = 3;
        }
        return code;
    }
}
