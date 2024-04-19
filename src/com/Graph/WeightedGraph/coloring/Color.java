package src.com.Graph.WeightedGraph.coloring;

import java.util.*;

public class Color {

    List<ColorNode>nodeList;

    public Color(List<ColorNode> list){
        this.nodeList=list;
    }

    public void addUndirectedEdge(int i, int j){
        ColorNode a= nodeList.get(i);
        ColorNode b = nodeList.get(j);
        a.neighbours.add(b);
        b.neighbours.add(a);
    }

    public static boolean isSafe(ColorNode node, int color, int[] coloring) {
        for (ColorNode neighbor : node.neighbours) {
            if (coloring[neighbor.getIndex()] == color) {
                return false;
            }
        }
        return true;
    }

    public static boolean graphColoring(Color graph, int m, int[] coloring) {
        int V = graph.nodeList.size();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(graph.nodeList.get(0));
        while (!stack.isEmpty()) {
            ColorNode currentNode = stack.pop();
            int vertex = currentNode.getIndex();
            if (vertex == V) {
                return true; // All vertices colored
            }
            boolean colorAssigned = false;
            for (int color = 1; color <= m; color++) {
                if (isSafe(currentNode, color, coloring)) {
                    coloring[vertex] = color;
                    colorAssigned = true;
                    stack.push(graph.nodeList.get(vertex + 1));
                    break;
                }
            }
            if (!colorAssigned) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    coloring[vertex] = 0;
                }
            }
        }
        return false;
    }

}
