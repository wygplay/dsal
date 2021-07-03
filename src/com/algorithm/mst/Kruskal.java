package com.algorithm.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 克鲁斯卡尔算法生成最小最小生成树
 * 核心两要素：1、边按照权重排序 2、判断待加入的边是否会和已加入最小生成树集合中的边形成回路；根据加入最小生成树的顶点，计算待加入边，两个顶点的终点,若终点一致，则必形成回路
 * @author wyg
 * @version 1.0
 * @date 2021/7/3 11:10
 */
public class Kruskal {
    private final char[] vertexes;
    private List<Edge> mst;
    List<Edge> edges;
    private int edgeNum;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[][]{
                {0, 12, INF, INF, INF, 16,14},
                {12, 0, 10, INF, INF, 7,INF},
                {INF, 10, 0, 3, 5, 6,INF},
                {INF, INF, 3, 0, 4, INF,INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        Kruskal k = new Kruskal(vertexes, matrix);
        k.kruskal();
    }
    public Kruskal(char[] vertexes, int[][] matrix) {
        int length = vertexes.length;
        this.vertexes = new char[length];
        System.arraycopy(vertexes, 0, this.vertexes, 0, length);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] != INF) {
                    this.edgeNum++;
                }
            }
        }
        this.mst = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            // j = i + 1，避免有向图中边的重复加入
            for (int j = i + 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != INF) {
                    edges.add(new Edge(vertexes[i], vertexes[j], matrix[i][j]));
                }
            }
        }
    }
    public void kruskal() {
        int[] ends = new int[vertexes.length];
        Collections.sort(edges);
        int num = 0;
        // n个顶点组成的连通图 n-1 条边可以连通
        for (int i = 0; i < edges.size() && num < vertexes.length -1; i++) {
            int m = getEnd(ends, getVertexPosition(edges.get(i).start));
            int n = getEnd(ends, getVertexPosition(edges.get(i).end));
            // 表示未形成回路
            if (m != n) {
                mst.add(edges.get(i));
                ends[m] = n;
                num++;
            }
        }
        System.out.println(mst);
    }

    private int getVertexPosition(char vertex) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertex == vertexes[i]) {
                return i;
            }
        }
        throw new IllegalArgumentException("边不存在");
    }

    private int getEnd(int[] ends, int i) {
        // ends[i] == 0 表示 i对应的终点是i本身，同时也意味着以i为start的边暂时未加入最小生成树集合
        while(ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    class Edge implements Comparable<Edge>{
        public char start;
        public char end;
        public int weight;
        public Edge(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{<" + start + ", " + end +
                    ">, weight=" + weight +
                    '}';
        }
    }

}
