package com.datastructure.recursion;

import java.util.*;

/**
 * 利用递归讯在迷宫中的最短路径
 * 思路：首先走法，共四个方向，排列组合，共有24种走法，（其实可以按8种去算，环形，顺、逆时针，8种）
 * 统计24种走法，记录每种走法格子数，比较最大最小
 */
public class MazeShortestPath {
    private static int[] down = {1, 0};
    private static int[] right = {0, 1};
    private static int[] up = {-1, 0};
    private static int[] left = {0, -1};
    private static int[][] moveWay = {down, right, up, left};
    private static int[][] moveFund = new int[4][2];
    private static List<int[][]> moves = new ArrayList<int[][]>();
    private static int num = 0;

    static boolean[] used = new boolean[4];
    public static Map<Integer, Integer> path = new HashMap<>();
    public static void main(String[] args) {

        findMove(moveWay, 0);

        for (int i = 0; i < moves.size(); i++) {
            findWay(getMaze(), 1, 1, moves.get(i), i);
        }
        System.out.println(path.size());
        for(Map.Entry<Integer, Integer> entry : path.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void findMove(int[][] move, int currentNum){
        if (currentNum == 4) {
            //注意不能直接赋值，引用传递会影响数据
            int[][] moveTmp = new int[moveFund.length][moveFund[0].length];
            for (int i = 0; i < moveFund.length; i++) {
                moveTmp[i] = moveFund[i];
            }
            moves.add(moveTmp);
            return;
        }
        for (int i = 0; i < move.length; i++) {
            if(!used[i]) {
                moveFund[currentNum]=move[i];
                used[i] = true;
                findMove(move, currentNum + 1);
                used[i] = false;
            }
        }
    }
    public static boolean findWay(int[][] maze, int i, int j, int[][] deviation, int k) {
        if (i == maze.length - 2 && j == maze[0].length - 2) {
            maze[i][j] = 2;
            num++;
            path.put(k, num);
            num = 0;
            return true;
        } else if (maze[i][j] == 0) {
            maze[i][j] = 2;
            num++;
            if (findWay(maze, i + deviation[0][0], j + deviation[0][1], deviation, k)) {
                return true;
            } else if (findWay(maze, i + deviation[1][0], j + deviation[1][1], deviation, k)) {
                return true;
            } else if (findWay(maze, i + deviation[2][0], j + deviation[2][1], deviation, k)) {
                return true;
            } else if (findWay(maze, i + deviation[3][0], j + deviation[3][1], deviation, k)) {
                return true;
            } else {
                maze[i][j] = 3;
                num--;
                return false;
            }
        } else {
            return false;
        }
    }

    public static int[][] getMaze() {
        int[][] maze = new int[10][10];
        for(int i = 0; i < maze.length; i++) {
            for (int j =0; j < maze[i].length; j++) {
                if(i == 0 || j==0 || i == maze.length -1 || j == maze[i].length - 1) {
                    maze[i][j] = 1;
                }
            }
        }
        maze[3][2] = 1;
        maze[4][1] = 1;
        maze[4][2] = 1;
        return maze;
    }
}