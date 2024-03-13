package src.com.Graph.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    public static List<WeightedGraphNode> primMinimumSpanningTree(WeightedGraph graph) {
        List<WeightedGraphNode> minimumSpanningTree = new ArrayList<>();
        List<WeightedGraphNode> nodeList = graph.nodeList;
        WeightedGraphNode startNode = nodeList.get(0); // Start from the first node

        PriorityQueue<WeightedGraphNode> priorityQueue = new PriorityQueue<>();
        for (WeightedGraphNode node : nodeList) {
            node.distance = Integer.MAX_VALUE; // Set distance to infinity for all nodes
            priorityQueue.add(node);
        }

        startNode.distance = 0; // Start node distance is 0

        while (!priorityQueue.isEmpty()) {
            WeightedGraphNode currentNode = priorityQueue.poll();
            minimumSpanningTree.add(currentNode);

            for (WeightedGraphNode neighbor : currentNode.neighbours) {
                //if node is not visited and has smallest distance from its neighbour than current
                if (priorityQueue.contains(neighbor) && currentNode.weightMap.get(neighbor) < neighbor.distance) {
                    neighbor.parent = currentNode;
                    neighbor.distance = currentNode.weightMap.get(neighbor);
                    // Update priority queue
                    priorityQueue.remove(neighbor);
                    priorityQueue.add(neighbor);
                }
            }
        }

        return minimumSpanningTree;
    }
}
