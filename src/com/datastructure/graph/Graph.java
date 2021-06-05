package com.datastructure.graph;

import java.util.*;

/**
 * 无向图，邻接矩阵实现
 * 为什么使用图？ 线性数据结构以及树，前继结点仅有一个，无法应对复杂情况
 * 顶点、边的关系
 * @author wyg
 * @version 1.0
 * @date 2021/6/1 19:55
 */
public class Graph {
    private List<String> vertexList;
    private int[][] edges;
    private int edgeNumber;
    private boolean[] isVisited;
    private Stack<String> stack;
    private Queue<Integer> queue;
    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
        stack = new Stack<>();
        queue = new LinkedList<>();
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return edgeNumber;
    }

    public List<String> getVertexList() {
        return this.vertexList;
    }

    /**
     * 插入边，无向图
     * @param vertexA 顶点a的坐标
     * @param vertexB 顶点b的坐标
     * @param weight 边的权重
     */
    public void insertEdge(int vertexA, int vertexB, int weight) {
        edges[vertexA][vertexB] = weight;
        edges[vertexB][vertexA] = weight;
        edgeNumber++;
    }

    /**
     *  构建有向图
     * @param vertexA
     * @param vertexB
     * @param weight
     */
    public void insertSingleEdge(int vertexA, int vertexB, int weight) {
        edges[vertexA][vertexB] = weight;
        edgeNumber++;
    }

    public String getVertex(int i) {
        return vertexList.get(i);
    }

    /**
     * 根据名称获取列表中对应顶点下标
     * @param vertex
     * @return
     */
    public int getVertexIndex(String vertex) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取起始结点的邻接结点
     * @return -1表示未找到邻接结点
     */
    public int getNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据当前邻接结点获取下一个邻接结点
     * @param index 起始结点下标
     * @param neighbor 邻接结点下标
     * @return 返回邻接结点下标，找不到返回-1
     */
    public int getNextNeighbor(int index, int neighbor) {
        for (int i = neighbor + 1; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    public int getNeighborWeight(int index, int neighbor) {
        return this.edges[index][neighbor];
    }
    /**
     * 深度优先遍历
     */
    public void depthFirstTraverse() {
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]) {
                depthFirstTraverse(i);
            }
        }
    }

    public void depthFirstTraverse(int index) {
        System.out.println(vertexList.get(index));
        isVisited[index] = true;
        int neighbor = getNeighbor(index);
        while (neighbor != -1) {
            if(!isVisited[neighbor]) {
                depthFirstTraverse(neighbor);
            }
            neighbor = getNextNeighbor(index, neighbor);
        }
    }

    /**
     *
     */
    public void broadFirstSearch() {
        for (int i = 0; i < vertexList.size(); i++) {
            if(!isVisited[i]) {
                broadFirstSearch(i);
            }
        }
    }

    public void broadFirstSearch(int index) {
        queue.offer(index);
        while(!queue.isEmpty()) {
            int next = queue.poll();
            if(!isVisited[next]) {
                System.out.println(vertexList.get(next));
                isVisited[next] = true;
                findNeighbors(next);
            }
        }
    }

    public void findNeighbors(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0 && !isVisited[i]) {
                queue.offer(i);
            }
        }
    }

    public void show() {
        for (int i = 0; i < edges.length; i++) {
            System.out.println(Arrays.toString(edges[i]));
        }
    }
}
