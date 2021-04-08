package com.datastructure.recursion;

import java.util.HashMap;

/**
 * 利用递归讯在迷宫中的最短路径
 */
public class MazeShortestPath {
    public static HashMap<Integer, Integer> path = new HashMap<>();
    public static void main(String[] args) {

    }
    public static int[][][] moveStrategy() {
        //下
        int[] down = {1, 0};
        int[] right = {0, 1};
        int[] up = {-1, 0};
        int[] left = {0, -1};

    }
    public static boolean findWay(int[][] maze, int i, int j, int[][] deviation, int k) {
        if(i == 6 && j == 6) {
            maze[i][j] = 2;
            return true;
        }else if(maze[i][j] == 0) {
            maze[i][j] = 2;
            if (findWay(maze, i + deviation[0][0], j + deviation[0][1], deviation, k)) {
                return true;
            }else if (findWay(maze, i + deviation[1][0], j + deviation[1][1], deviation, k)) {
                return true;
            } else if (findWay(maze, i + deviation[2][0], j + deviation[2][1], deviation, k)) {
                return true;
            } else if (findWay(maze, i + deviation[3][0], j + deviation[3][1], deviation, k)) {
                return true;
            } else {
                maze[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }

}