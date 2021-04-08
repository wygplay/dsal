package com.datastructure.recursion;

import java.util.Arrays;

/**
 * 模拟迷宫问题，两点之间的路径
 * 障碍、重复标记
 * 行走策略：下、右、上、左
 *
 */
public class MazeQuestion {
    public static void main(String[] args) {
        //二维数组模拟迷宫，1表示障碍或墙， 2表示已经通过的路，3表示无法通过
        int[][] maze = new int[8][8];
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
        findWay(maze, 1, 1);
        for(int i = 0; i < maze.length; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }

    }

    public static boolean findWay(int[][] maze, int i, int j) {
        if(i == 6 && j == 6) {
            maze[i][j] = 2;
            return true;
        }else if(maze[i][j] == 0) {
            maze[i][j] = 2;
            if (findWay(maze, i + 1, j)) {
                return true;
            }else if (findWay(maze, i, j + 1)) {
                return true;
            } else if (findWay(maze, i -1, j)) {
                return true;
            } else if (findWay(maze, i, j - 1)) {
                return true;
            } else {
                maze[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }

    }
}
