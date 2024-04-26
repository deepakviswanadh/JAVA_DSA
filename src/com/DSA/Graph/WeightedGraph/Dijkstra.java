package src.com.DSA.Graph.WeightedGraph;

import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    public List<WeightedGraphNode> nodeList;

    public Dijkstra(List<WeightedGraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void printPath(WeightedGraphNode node) {
        if (node.parent != null) {
            printPath(node.parent);
        }
        System.out.println(node.value + " ");
    }

    public void addWeightedEdge(int i, int j, int distance) {
        WeightedGraphNode node1 = nodeList.get(i);
        WeightedGraphNode node2 = nodeList.get(j);
        node1.neighbours.add(node2);
        node1.weightMap.put(node2, distance);
    }

    public void dijkshtraFlow() {
        WeightedGraphNode root = nodeList.get(0);
        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        root.distance = 0;
        while (!queue.isEmpty()) {
            WeightedGraphNode removed = queue.poll();
            if (!removed.isVisited) {
                removed.isVisited = true;
            }
            for (WeightedGraphNode nei : removed.neighbours) {
                //not visited
                if (queue.contains(nei)) {
                    if (nei.distance > removed.distance + removed.weightMap.get(nei)) {
                        nei.distance = removed.distance + removed.weightMap.get(nei);
                        nei.parent = removed;
                        //refresh the queue so that it will adjust the queue basing on the new distance
                        queue.remove(nei);
                        queue.add(nei);
                    }
                }
            }
        }

        for (WeightedGraphNode node : nodeList) {
            System.out.println("Node " + node.value + node.distance + "path ");
            printPath(node);
        }

    }
}
