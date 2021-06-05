package com.algorithm.dijkstra;

import com.datastructure.graph.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 图
 * 标志结点已查找过的结点的记录
 * 起始值到已处理的结点值的最小路径值表
 *
 *
 * @author wyg
 * @version 1.0
 * @date 2021/6/5 16:55
 */
public class Dijkstra {
    /**
     * 记录已处理结点到起始结点的最小路径值
     */
    private Map<String, Integer> shortestPath;
    /**
     * 记录已访问过的结点
     */
    private Map<String, Boolean> processed;
    /**
     * 记录结点与父结点关系
     */
    private Map<String, String> parents;
    private Graph graph;
    public Dijkstra(Graph graph) {
        this.shortestPath = new HashMap<>();
        this.processed = new HashMap<>();
        this.parents = new HashMap<>();
        this.graph = graph;
    }

    /**
     * 解决数组实现的图中最小路径问题
     * @param start 起始位置
     * @param end 终点
     * @return 返回两点之间最小路径值
     */
    public int findShortestPath(String start, String end) {
        //初始化，仅仅是为了测试时可以使用同一个对象多次查找
        this.parents = new HashMap<>();
        this.processed = new HashMap<>();
        for (String vertex : graph.getVertexList()) {
            if (vertex.equals(start)) {
                shortestPath.put(vertex, 0);
                continue;
            }
            shortestPath.put(vertex, Integer.MAX_VALUE);
        }
        String vertex = start;
        //注意会一直取到类路径可以达到的尾端（无邻接结点），判断vertex==end时，提前终止
        while (vertex != null && vertex.length() > 0 && !vertex.equals(end)) {
            int index = graph.getVertexIndex(vertex);
            //找打vertex的邻接结点
            if (index == -1) {
                throw new IllegalArgumentException("顶点不存在: " + vertex);
            }
            int neighbor = graph.getNeighbor(index);
            //一个一个处理当前结点的邻接结点
            while (neighbor != -1) {
                int weight = graph.getNeighborWeight(index, neighbor);
                int newPathValue = shortestPath.get(vertex) + weight;
                String neighborName = graph.getVertex(neighbor);
                Integer shortest = shortestPath.get(neighborName);
                if (newPathValue < shortest) {
                    shortestPath.put(neighborName, newPathValue);
                    parents.put(neighborName, vertex);
                }
                neighbor = graph.getNextNeighbor(index, neighbor);
            }
            //将当前结点标记为已处理，不再重复处理
            processed.put(vertex, true);
            //找到候补节点中最小值
            vertex = findUnprocessedShortestNode();
        }
        return shortestPath.get(end);
    }

    public String findUnprocessedShortestNode() {
        int shortestValue = Integer.MAX_VALUE;
        String vertex = null;
        for (Map.Entry<String, Integer> entry : shortestPath.entrySet()) {
            if (entry.getValue() < shortestValue && !Boolean.TRUE.equals(processed.get(entry.getKey()))) {
                shortestValue = entry.getValue();
                vertex = entry.getKey();
            }
        }
        return vertex;
    }

    public void showPath(String end) {
        do {
            System.out.print(end + "-->");
            end = parents.get(end);
        } while (end != null);
        System.out.println("----------");
    }

    public void showShortestPath() {
        for (Map.Entry<String, Integer> entry : shortestPath.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }
}
