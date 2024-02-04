package src.com.Graph.examples;

import java.util.*;

public class Examples {

    public void validPath(int[][] edges) {
        //creating adj list for nodes basing on edges
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
    }
}
