package com.algorithm.dynamicprograming;

/**
 * 背包问题：
 * 背包仅有4磅的容量，吉他1磅1500元，音响 4磅 3000元，笔记本 3磅 2000元，背包怎么装可以利益最大化
 *
 * @author wyg
 * @version 1.0
 * @date 2021/6/13 15:16
 */
public class BagQuestion {
    /**
     * 背包重量分解
     */
    private int[] bagWeight;
    /**
     * 带选择物品重量
     */
    private int[] selectionWeight;
    /**
     * 待选择物品价值
     */
    private int[] selectionValue;
    /**
     * 所有的选择性
     */
    private int[][] selection;

    public BagQuestion(int[] bagWeight, int[] selectionWeight, int[] selectionValue) {
        this.bagWeight = bagWeight;
        this.selectionWeight = selectionWeight;
        this.selectionValue = selectionValue;
        this.selection = new int[selectionWeight.length][bagWeight.length];
    }

    public int getMaxInterest() {
        for (int i = 0; i < selectionWeight.length; i++) {
            for (int j = 0; j < bagWeight.length;j++) {
                //bag weight大于当前待选择物品时才可以将当前物品加入
                if(bagWeight[j] < selectionWeight[i]) {
                    selection[i][j] = i > 0 ? selection[i - 1][j] : 0;
                } else if (bagWeight[j] == selectionWeight[i]) {
                    selection[i][j] = i > 0 ? Math.max(selection[i - 1][j], selectionValue[i]) : selectionValue[i];
                } else {
                    if (i > 0) {
                        if (j > 0) {
                            //注意bagWeight[j] - selectionWeight[i] - 1 这个地方需要优化，这里是在取巧
                            selection[i][j] = Math.max(selection[i - 1][j], selectionValue[i] + selection[i - 1][getWeightIndex(bagWeight[j] - selectionWeight[i])]);
                        } else {
                            selection[i][j] = Math.max(selection[i - 1][j], selectionValue[i]);
                        }
                    } else {
                        selection[i][j] = selectionValue[i];
                    }
                }

            }
        }
        return selection[selection.length - 1][selection[0].length - 1];
    }

    public int[] getBagWeight() {
        return bagWeight;
    }

    public void setBagWeight(int[] bagWeight) {
        this.bagWeight = bagWeight;
    }

    public int[] getSelectionWeight() {
        return selectionWeight;
    }

    public void setSelectionWeight(int[] selectionWeight) {
        this.selectionWeight = selectionWeight;
    }

    public int[] getSelectionValue() {
        return selectionValue;
    }

    public void setSelectionValue(int[] selectionValue) {
        this.selectionValue = selectionValue;
    }

    public int[][] getSelection() {
        return selection;
    }

    public void setSelection(int[][] selection) {
        this.selection = selection;
    }

    public int getWeightIndex(int weight) {
        for (int i = 0; i < bagWeight.length; i++) {
            if (bagWeight[i] == weight) {
                return i;
            }
        }
        return -1;
    }
}
