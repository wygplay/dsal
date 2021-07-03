package com.algorithm.mst;

/**
 * 普利姆（Prim）算法
 *
 * @author wyg
 * @version 1.0
 * @date 2021/6/28 21:35
 */
public class Prim {

    public static void main(String[] args) {
        String[] vertexes = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] edges = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},
        };

        Graph graph = createGraph(vertexes, edges);
        prim(graph, 1);
    }

    public static void prim(Graph graph, int v) {
        boolean[] visited = new boolean[graph.vertexes.length];
        visited[v] = true;
        int vertexNum = graph.vertexes.length;
        // n个顶点n-1条边
        int start = -1;
        int end = -1;
        for (int k = 1; k < vertexNum; k++) {
            // 遍历所有已添加结点的所有未访问过的邻接结点中最小的那个
            int minWeight = 10000;
            for (int i = 0; i < vertexNum; i++) {
                if(visited[i]) {
                    int tempIndex = findMinWeightIndex(graph.edges[i], visited);
                    if (tempIndex == -1) {
                        continue;
                    } else if (graph.edges[i][tempIndex] < minWeight) {
                        start = i;
                        end = tempIndex;
                        minWeight = graph.edges[i][end];
                    }
                }
            }
            visited[end] = true;
            System.out.println(graph.vertexes[start] + " -> " + graph.vertexes[end] + ", 边长：" + minWeight);
        }
    }
    public static int findMinWeightIndex(int[] adjacentNode, boolean[] visited) {
        int minWeight = 10000;
        int minWeightIndex = -1;
        for (int i = 0; i < adjacentNode.length; i++) {
            if (adjacentNode[i] < minWeight && !visited[i]) {
                minWeightIndex = i;
                minWeight = adjacentNode[i];
            }
        }
        return minWeightIndex;
    }
    private static class Graph {
        String[] vertexes;
        int[][] edges;

        public Graph(String[] vertexes, int[][] edges) {
            this.vertexes = vertexes;
            this.edges = edges;
        }
    }
    public static Graph createGraph(String[] vertexes, int[][] edges) {
        return new Graph(vertexes, edges);
    }
}
