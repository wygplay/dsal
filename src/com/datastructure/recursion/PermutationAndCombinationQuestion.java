package com.datastructure.recursion;

import java.util.Stack;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/4/7 22:11
 */
public class PermutationAndCombinationQuestion {
    public static int cnt = 0;
    public static Stack<Integer> stack = new Stack<Integer>();
    public static boolean[] picked = new boolean[100];

    public static void main(String[] args) {
        case3(1, 5, 0, 3);
        System.out.println(cnt);
    }
    /**
     * 假设袋子里有编号为1,2,...,m这m个球。现在每次从袋子中取一个球几下编号，放回袋中再取，取n次作为一组，枚举所有可能的情况。（有序）
     * @param minCode 小球最小编号
     * @param maxCode 小球最大编号
     * @param currentNum 当前已选择小球个数
     * @param expectedNum 共需要选择球的个数
     */
    public static void case1(int minCode, int maxCode, int currentNum, int expectedNum) {
        //退出条件，已经选择的小球个数与共需要选择的小球个数相等
        if (currentNum == expectedNum) {
            System.out.println(stack);
            cnt++;
            return;
        }
        //每次选择时，面临的情况与需要处理的事情
        //面临：将球编号记录，选择下一个，直至选择完毕，然后需要将球取出，以便进行下一可能性的选择的统计（for循环）
        for(int i = minCode; i <= maxCode; i++) {
            stack.push(i);
            case1(minCode, maxCode, currentNum + 1, expectedNum);
            stack.pop();
        }
    }

    /**
     * 假设袋子里有编号为1,2,...,m这m个球。现在每次从袋子中取一个球几下编号，不放回袋中，再取，取n次作为一组，枚举所有可能的情况。m必须大于n
     * @param minCode 小球最小编号
     * @param maxCode 小球最大编号
     * @param currentNum 当前已选择小球个数
     * @param expectedNum 共需要选择球的个数
     */
    public static void case2(int minCode, int maxCode, int currentNum, int expectedNum) {
        //退出条件，已经选择的小球个数与共需要选择的小球个数相等
        if (currentNum == expectedNum) {
            System.out.println(stack);
            cnt++;
            return;
        }
        //每次选择时，面临的情况与需要处理的事情
        //面临：先判断是否选过，将球编号记录，并且选择下一个时，前面几个不能再选，直至选择完毕，然后需要将球取出，以便进行下一可能性的选择的统计（for循环）
        for(int i = minCode; i <= maxCode; i++) {
            //判断当前是否已选
            if(!picked[i]) {
                stack.push(i);
                //需要进行辅助，记录当前已选的的
                picked[i] = true;
                case2(minCode, maxCode, currentNum + 1, expectedNum);
                stack.pop();
                //标记当前废除
                picked[i] = false;
            }
        }
    }

    /**
     * 假设袋子里有编号为1,2,...,m这m个球。现在每次从袋子中取n个球记下编号，枚举所有可能的情况。（无序）
     * 可以由第二种进行简化，
     * @param minCode 小球最小编号
     * @param maxCode 小球最大编号
     * @param currentNum 当前已选择小球个数
     * @param expectedNum 共需要选择球的个数
     */
    public static void case3(int minCode, int maxCode, int currentNum, int expectedNum) {
        //退出条件，已经选择的小球个数与共需要选择的小球个数相等
        if (currentNum == expectedNum) {
            System.out.println(stack);
            cnt++;
            return;
        }
        //每次选择时，面临的情况与需要处理的事情
        //面临：将球编号记录，之前选过的都不能选，选择下一个，直至选择完毕，然后需要将球取出，以便进行下一可能性的选择的统计（for循环）
        //简化思路，从小到大，不走回头路，回头就会重复，因为小编号球可能行已经统计完毕，再回头定会重复
        for(int i = minCode; i <= maxCode; i++) {
            stack.push(i);
            case3(i + 1, maxCode, currentNum + 1, expectedNum);
            stack.pop();
        }
    }
}
