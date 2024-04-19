package src.com.Graph.WeightedGraph.Bipartite;

import java.util.LinkedList;
import java.util.List;

public class BipartiteNode {

    String nodeValue;
    Integer index;
    boolean visited = false;
    int color;


    List<BipartiteNode> neighbours;
    BipartiteNode matchedNode; // Attribute to store matched node

    public BipartiteNode(String nodeValue, Integer index) {
        this.nodeValue = nodeValue;
        this.index = index;
        this.visited = false;
        this.neighbours = new LinkedList<>();
        this.matchedNode = null; // Initialize matchedNode as null
    }


    public BipartiteNode getMatchedNode() {
        return matchedNode;
    }

    public void setMatchedNode(BipartiteNode matchedNode) {
        this.matchedNode = matchedNode;
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public List<BipartiteNode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<BipartiteNode> neighbours) {
        this.neighbours = neighbours;
    }
}
