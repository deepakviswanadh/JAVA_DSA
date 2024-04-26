package src.com.DSA.Graph.WeightedGraph;

import java.util.HashMap;
import java.util.List;

public class WeightedGraphNode implements Comparable<WeightedGraphNode> {
    public String value;
    public List<WeightedGraphNode> neighbours;
    public HashMap<WeightedGraphNode, Integer> weightMap;
    public Integer distance;
    public Integer index;

    public WeightedGraphNode parent;

    public boolean isVisited;

    public WeightedGraphNode(String value, List<WeightedGraphNode> neighbours, HashMap<WeightedGraphNode, Integer> edges, Integer distance, Integer index, WeightedGraphNode parent, boolean isVisited) {
        this.value = value;
        this.neighbours = neighbours;
        this.weightMap = new HashMap<>();
        this.distance = Integer.MAX_VALUE;
        this.index = index;
        this.parent = null;
        this.isVisited = false;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @Override
    public int compareTo(WeightedGraphNode node) {
        return this.distance - node.distance;
    }
}
