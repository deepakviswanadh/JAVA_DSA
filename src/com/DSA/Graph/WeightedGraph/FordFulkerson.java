package src.com.DSA.Graph.WeightedGraph;

import java.util.*;

public class FordFulkerson {
    private static final int vertices = 7;

    // Returns the maximum flow from source to sink in the given graph
    //along with max distinct matching of set U

    public int countDistinctMatchedVertices(int[][] graph, int sizeU, int sizeV) {
        int totalVertices = sizeU + sizeV + 2;
        int source = 0, sink = totalVertices - 1;
        int[][] residualGraph = new int[totalVertices][totalVertices];
        int maxFlow=0;

        //source->sizeU
        //sizeU+sizeV->sink

        // Connect source to all vertices in U
        for (int u = 1; u <= sizeU; u++) {
            residualGraph[source][u] = 1;
        }

        // Connect all vertices in U to V based on the original graph
        for (int u = 1; u <= sizeU; u++) {
            for (int v = 1; v <= sizeV; v++) {
                if (graph[u - 1][v - 1] == 1) {
                    residualGraph[u][sizeU + v] = 1;
                }
            }
        }

        // Connect all vertices in V to the sink
        for (int v = 1; v <= sizeV; v++) {
            residualGraph[sizeU + v][sink] = 1;
        }

        int[] parent = new int[totalVertices];
        boolean[] matchedU = new boolean[sizeU + 1];
        boolean[] matchedV = new boolean[sizeV + 1];

        while (bfs(residualGraph, source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            int v = sink;
            while (v != source) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
                v = u;
            }
            v = sink;
            while (v != source) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;

                // Track matched vertices in U and V
                if (u != source && v != sink && u <= sizeU && v > sizeU && v <= sizeU + sizeV) {
                    matchedU[u] = true;
                    matchedV[v - sizeU] = true;
                }
                v = u;
            }
            maxFlow+=pathFlow;
        }
        int matchedVerticesCount = 0;
        int i = 1;
        while (i <= sizeU) {
            if (matchedU[i]) matchedVerticesCount++;
            i++;
        }
        i = 1;
        while (i <= sizeV) {
            if (matchedV[i]) matchedVerticesCount++;
            i++;
        }
        return matchedVerticesCount;
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