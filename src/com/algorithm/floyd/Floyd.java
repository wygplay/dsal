package com.algorithm.floyd;

import com.datastructure.graph.Graph;

import java.util.Arrays;
import java.util.List;

/**
 * 弗洛伊德算法解决图最短路径问题
 * @author wyg
 * @version 1.0
 * @date 2021/7/3 15:12
 */
public class Floyd {
    private char[] vertexes;
    private int[][] distances;
    private int[][] pre;

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] edges = {
                {0, 5, 7, 10000, 10000, 10000, 2},
                {5, 0, 10000, 9, 10000, 10000, 3},
                {7, 10000, 0, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 0, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 0, 5, 4},
                {10000, 10000, 10000, 4, 5, 0, 6},
                {2, 3, 10000, 10000, 4, 6, 0},
        };
        Floyd f = new Floyd(vertexes, edges);
        System.out.println(f.floyd('A', 'D'));
    }

    public Floyd(char[] vertexes, int[][] edges) {
        this.vertexes = vertexes;
        distances = new int[edges.length][edges.length];
        pre = new int[edges.length][edges.length];

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                distances[i][j] = edges[i][j];
                if (edges[i][j] != 10000) {
                    pre[i][j] = i;
                } else {
                    pre[i][j] = -1;
                }
            }
        }
    }

    public int floyd(char start, char end) {
        // 以每个顶点为中间结点
        for (int k = 0; k < distances.length; k++) {
            // 中间结点的前继结点
            for (int i = 0; i < distances.length; i++) {
                //中间结点的后继结点
                for (int j = 0; j < distances.length; j++) {
                    int len = distances[i][k] + distances[k][j];
                    if (len < distances[i][j]) {
                        distances[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
        findPath(getPosition(start), getPosition(end));
        show();
        return distances[getPosition(start)][getPosition(end)];
    }

    private int getPosition(char vertex) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == vertex) {
                return i;
            }
        }
        throw new IllegalArgumentException("顶点不存在");
    }

    private void show() {
        for (int i = 0; i < distances.length; i++) {
            System.out.println(Arrays.toString(distances[i]));
        }
    }

    private void findPath(int start, int end) {
        int k = pre[start][end];
        System.out.println("<" + vertexes[end] + ", " + vertexes[k] + ">, weight: " + distances[k][end]);
        if (start == k) {
            return;
        }
        findPath(start, k);
    }

}
