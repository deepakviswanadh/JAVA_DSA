package src.com.Graph.WeightedGraph;

import java.util.*;

public class FordFulkerson {
    private static final int vertices = 7;

    // Returns the maximum flow from source to sink in the given graph
    public int fordFulkerson(int[][] graph, int source, int sink) {

        // the residual graph represents the remaining capacity
        // of edges after the initial flow has been established.
        int[][] residualGraph = new int[vertices][vertices];
        for (int i = 0; i < vertices; ++i)
            for (int j = 0; j <vertices; ++j)
                residualGraph[i][j] = graph[i][j];

        int[] parent = new int[vertices];

        int maxFlow = 0;

        // Augment the flow while there is path from source to sink
        while (bfs(residualGraph, source, sink, parent)) {
            // Find minimum residual capacity of the edges along the path filled by BFS.
            int pathFlow = Integer.MAX_VALUE;

            // Finding the Minimum Residual Capacity along the Path
            int v = sink;
            while (v != source) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
                v = u;
            }

            // Updating Residual Capacities and Reverse Edges along the Path
            v = sink;
            while (v != source) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
                v = u;
            }

            // Add path flow to overall flow
            maxFlow += pathFlow;
        }

        // Return the overall flow
        return maxFlow;
    }

    // Returns true if there is a path from source 's' to sink 't' in residual graph.
    private boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < vertices; v++) {
                //consider edges with only remaining capacity (capacity>0)
                if (!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return visited[sink];
    }
}
