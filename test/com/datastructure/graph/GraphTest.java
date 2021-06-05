package com.datastructure.graph;

import com.algorithm.dijkstra.Dijkstra;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/6/1 20:14
 */
public class GraphTest {

    public Graph graph;
    public Graph graphAnother;
    public Graph singleGraph;
    @Before
    public void init() {
        graph = new Graph(5);
        graphAnother = new Graph(8);

        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        String[] vertexs = {"1", "2", "3", "4", "5", "6", "7", "8"};
        for(String vertex: vertexs) {
            graphAnother.insertVertex(vertex);
        }
        graphAnother.insertEdge(0, 1, 1);
        graphAnother.insertEdge(0, 2, 1);
        graphAnother.insertEdge(1, 3, 1);
        graphAnother.insertEdge(1, 4, 1);
        graphAnother.insertEdge(3, 7, 1);
        graphAnother.insertEdge(4, 7, 1);
        graphAnother.insertEdge(2, 5, 1);
        graphAnother.insertEdge(2, 6, 1);
        graphAnother.insertEdge(5, 6, 1);

        singleGraph = new Graph(6);
        singleGraph.insertVertex("Sheet music");
        singleGraph.insertVertex("Vinyl records");
        singleGraph.insertVertex("Guitar");
        singleGraph.insertVertex("Piano");
        singleGraph.insertVertex("Drum");
        singleGraph.insertVertex("Poster");
        // "sheet music" -> "Vinyl records", 5
        // "sheet music" -> "poster" 1
        // "Vinyl records" -> "guitar" 15
        // "Vinyl records" -> "drum" 20
        // "poster" -> "guitar" 30
        // "poster" -> "drum" 35
        // "guitar" -> "piano" 20
        // "drum" -> "piano" 10
        singleGraph.insertSingleEdge(0, 1, 5);
        singleGraph.insertSingleEdge(0, 5, 1);
        singleGraph.insertSingleEdge(1, 2, 15);
        singleGraph.insertSingleEdge(1, 4, 20);
        singleGraph.insertSingleEdge(5, 2, 30);
        singleGraph.insertSingleEdge(5, 4, 35);
        singleGraph.insertSingleEdge(2, 3, 20);
        singleGraph.insertSingleEdge(4, 3, 10);
    }

    @Test
    public void testGraph() {
        //A-B, A-C, B-C, B-D, B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.show();

        //graph.depthFirstTraverse();
        graph.broadFirstSearch();
    }

    @Test
    public void testGraphAnother() {

        graphAnother.show();

        //graphAnother.depthFirstTraverse();
        graphAnother.broadFirstSearch();

    }

    @Test
    public void dijkstra() {
        Dijkstra dijkstra = new Dijkstra(singleGraph);
        assertEquals(35, dijkstra.findShortestPath("Sheet music", "Piano"));
        dijkstra.showPath("Piano");
        dijkstra.showShortestPath();
        assertEquals(20, dijkstra.findShortestPath("Sheet music", "Guitar"));
        dijkstra.showPath("Guitar");
        dijkstra.showShortestPath();
        assertEquals(20, dijkstra.findShortestPath("Guitar", "Piano"));
        dijkstra.showPath("Piano");
        dijkstra.showShortestPath();
    }
}