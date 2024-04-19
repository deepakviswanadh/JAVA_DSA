package src.com.Graph.WeightedGraph.coloring;

import java.util.LinkedList;
import java.util.List;

public class ColorNode {
    String nodeValue;
    Integer index;

    List<ColorNode> neighbours;

    boolean visited = false;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ColorNode(String nodeValue, Integer index) {
        this.nodeValue = nodeValue;
        this.index = index;
        this.neighbours= new LinkedList<>();
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
