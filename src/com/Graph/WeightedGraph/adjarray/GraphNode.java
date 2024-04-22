package src.com.Graph.WeightedGraph.adjarray;

public class GraphNode {
    String nodeValue;
    Integer index;

    boolean visited = false;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public GraphNode(String nodeValue, Integer index) {
        this.nodeValue = nodeValue;
        this.index = index;
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
