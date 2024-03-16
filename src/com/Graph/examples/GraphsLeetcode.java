package src.com.Graph.examples;

import java.util.*;


//count number of connected components in an undirected graph
class GrpahsLeetcode {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) return 0;

        // Create adjacency list representation of the graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsIterative(i, adjList, visited);
                count++;
            }
        }

        return count;
    }

    private void dfsIterative(int start, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            visited[node] = true;

            for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
