package src.com.Graph;

import java.util.*;
import src.com.Graph.GraphNode;

public class Graph {
    List<GraphNode> nodeList;
    int[][] graph;

    public Graph(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
        graph = new int[nodeList.size()][nodeList.size()];
    }

    public List<GraphNode> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }

    public void addUndirectedEdge(int i, int j) {
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("   ");
        for (GraphNode eachNode : nodeList) {
            result.append(eachNode.getNodeValue() + " ");
        }
        result.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            result.append(nodeList.get(i).getNodeValue() + ": ");
            for (int j : graph[i]) {
                result.append(j + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public List<GraphNode> getNeighbours(GraphNode node) {
        int index = node.getIndex();
        List<GraphNode> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[index][i] == 1) {
                result.add(nodeList.get(i));
            }
        }
        return result;
    }

    public void bfs() {
        Queue<GraphNode> data = new LinkedList<>();
        data.add(nodeList.get(0));
        while (!data.isEmpty()) {
            GraphNode node = data.remove();
            if (!node.isVisited()) {
                node.setVisited(true);
                System.out.print(node.getNodeValue() + " ");
            }
            List<GraphNode> neighbours = getNeighbours(node);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.visited) {
                    data.add(neighbour);
                }
            }
        }
    }

    public void dfs() {
        Stack<GraphNode> data = new Stack<>();
        data.push(nodeList.get(0));
        while (!data.isEmpty()) {
            GraphNode removed = data.pop();
            if (!removed.isVisited()) {
                System.out.println(removed.getNodeValue() + " ");
                removed.setVisited(true);
            }
            List<GraphNode> neighbours = getNeighbours(removed);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisited()) {
                    data.add(neighbour);
                }
            }
        }
    }
}
