package com.datastructure.recursion;

/**假设有n个楼梯，每次可以走1或2步，统计共有几种走法
 * @author wyg
 * @version 1.0
 * @date 2021/4/7 23:22
 */
public class Stairs {
    public static int cnt = 0;
    /**
     * 每次可选1或2步，楼梯剩余小于2时，即可退出，因为最后一步结果已经确定
     * 通过统计每次1步，2步,累计值至目标，并统计实现目标的次数
     */
    public static int criticalPoint = 2;

    public static void main(String[] args) {
        clamp(10);
        System.out.println(cnt);
        System.out.println(clampAnother(10));
    }
    public static void clamp(int n){
        if (n < criticalPoint) {
            cnt++;
            return;
        }
        //其实就只有n-1,n-2,跟第二种思想类似，只不过是遍历所有情况，统计次数
        for (int i = 1; i < 3; i++) {
            clamp(n - i);
        }
    }

    public static int clampAnother(int n) {
        if (n < 1) {
            return -1;
        } else if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        else {
            //相比第一种方式更抽象一些，每出一次之后，剩下全部情况就是n-1个台阶怎么走和n-2个台阶怎么走，两种的和
            return clampAnother(n - 1) + clampAnother(n - 2);
        }
    }
}
