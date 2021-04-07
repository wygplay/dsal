package com.datastructure.stack;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/3/27 16:57
 * 分两步：
 * 1、中缀表达式转后缀表达式
 * Arraylist存储后缀表达表达式，一个符号栈
 * 1）、遇见数字直接推入数栈
 * 2）、新符号始终入符号栈，栈中的符号优先级小于或等于新符号（"(", ")"两个需要特殊处理的除外）的全部出栈
 * 3）、"("直接入符号栈
 * 4）、 ")"出现时，符号栈依次出栈，添加至list，直到找到"("停止，注意括号不进入后缀表达式
 * 2、后缀表达式的计算
 */
public class ReversePolishCalculator {
    public static void main(String[] args) {
        String infix = "3 + ( 5 * 8 + 1 + 4 ) * 5";
        String suffixExpression = convertInfixToSuffix(infix);
        System.out.println(computeSuffixExpression(suffixExpression));
    }

    public static String convertInfixToSuffix(String infix) {
        List<String> suffix = new ArrayList<String>();
        ArrayStack signStack = new ArrayStack(20);
        String[] elements = infix.split(" ");
        for (String element : elements) {
            if (isNumber(element)) {
                suffix.add(element);
            } else if (")".equals(element)) {
                while(!"(".equals(signStack.getTop())) {
                    suffix.add(signStack.pop());
                }
                //去除括号
                signStack.pop();
            } else if (isSign(element)) {
                while(!signStack.isEmpty()) {
                    if (Calculator.compareSignPriority(element, signStack.getTop())) {
                        break;
                    } else if ("(".equals(signStack.getTop())) {
                        //符号栈中遇到"("，直接入栈，当然除了")"
                        break;
                    } else{
                        String sign = signStack.pop();
                        suffix.add(sign);
                    }
                }
                //新符号总是会入栈的，变化只是前面的符号
                signStack.push(element);
            }
        }
        while (!signStack.isEmpty()) {
            suffix.add(signStack.pop());
        }
        return String.join(" ", suffix);
    }

    public static int computeSuffixExpression(String expression) {
        ArrayIntStack stack = new ArrayIntStack(20);
        String[] elements = expression.split(" ");
        for (String element : elements) {
            if (isNumber(element)) {
                stack.push(Integer.parseInt(element));
            } else if (isSign(element)) {
                int numOne = stack.pop();
                int numTwo = stack.pop();
                int res = Calculator.compute(numTwo, numOne, element);
                stack.push(res);
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String e){
        return e.matches("\\d+");
    }

    public static boolean isSign(@NotNull String s) {
        if("*".equals(s) || "+".equals(s) || "-".equals(s) || "(".equals(s) || ")".equals(s)) {
            return true;
        }
        return false;
    }

}
