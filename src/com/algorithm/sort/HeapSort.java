package com.algorithm.sort;

/**
 * 思路：
 * 本例采用升序排列，因此采用大顶堆构建堆
 * 1、数组初始化为堆，即树中任意一个父结点值均不小于其子结点值
 * 2、堆顶元素与最后一个元素进行交换
 * 3、将交换后的最后一个元素（原堆顶元素）排除在外，重新构建堆结构，注意此时相当于仅仅是堆顶元素发生了改变，
 *    因此除堆顶外，其余子树均处于堆结构状态，因此仅需要在顶点处处理依次adjustHeap方法中的内容即可
 * @author wyg
 * @version 1.0
 * @date 2021/5/12 22:31
 */
public class HeapSort {

    public static void sort(int[] arr) {
        //数组整个初始化为堆结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //交换、重排
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            adjustHeap(arr, 0, j);
        }

    }

    /**
     * 以i点为顶点包括其子树在内组成的区域子树（相对于整个二叉树来说，前提是顶点以下子树是堆结构），转为堆结构
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //以i点为顶点，转为堆结构
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k + 1]) {
                //若右子结点大于左子结点，则指向右子结点
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    //较容易理解版本，相比于上面版本增加了交换次数（本质上就只有初始值arr[i]在不停被交换，因此可以简化为上面版本）
    public static void adjustHeapEasyUnderstanding(int[] arr, int i, int length) {
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k + 1]) {
                //若右子结点大于左子结点，则指向右子结点
                k++;
            }
            if (arr[k] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                i = k;
            } else {
                break;
            }
        }
    }

    public static void sortWithMisunderstanding(int[] arr, int length) {
        if(length == 0) {
            return;
        }
        int index = length/2 - 1;
        while(index >= 0) {
            int temp = arr[index];
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left <= length - 1 && right <= length -1) {
                if(arr[left] < arr[right] && arr[right] > arr[index]) {
                    arr[index] = arr[right];
                    arr[right] = temp;
                } else if (arr[right] < arr[left] && arr[left] > arr[index]) {
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
            } else if (left <= length - 1){
                if(arr[left] > arr[index]) {
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
            }
            index--;
        }
        //以上代码并未将数组初始化为堆结构（所有父结点均不小于子结点），仅仅是将最大值，推至堆顶，
        int temp = arr[0];
        arr[0] = arr[length - 1];
        arr[length - 1] = temp;
        sortWithMisunderstanding(arr, length - 1);
    }

}
