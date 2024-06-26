package src.com.DSA.Graph.WeightedGraph;

import java.util.*;

public class Kruskal {

    public List<WeightedGraphNode> kruskalMST(Dijkstra graph) {
        List<WeightedGraphNode> result = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        for (WeightedGraphNode node : graph.nodeList) {
            for (Map.Entry<WeightedGraphNode, Integer> entry : node.weightMap.entrySet()) {
                edges.add(new Edge(node, entry.getKey(), entry.getValue()));
            }
        }

        // Step 2: Sort all edges in ascending order
        edges.sort((a,b)->a.weight-b.weight);

        UnionFind unionFind = new UnionFind(graph.nodeList.size());

        for (Edge edge : edges) {
            WeightedGraphNode source = edge.source;
            WeightedGraphNode destination = edge.destination;

            int sourceParent = unionFind.find(source.index);
            int destinationParent = unionFind.find(destination.index);

            if (sourceParent != destinationParent) {
                result.add(source);
                result.add(destination);
                unionFind.union(sourceParent, destinationParent);
            }
        }

        return result;
    }

    // Helper class to represent an edge
    static class Edge {
        WeightedGraphNode source;
        WeightedGraphNode destination;
        int weight;

        Edge(WeightedGraphNode source, WeightedGraphNode destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Helper class for Union Find operations
    static class UnionFind {
        int[] parent;

        UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }
    }
}
