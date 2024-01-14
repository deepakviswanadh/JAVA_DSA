package src.com.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNodeAdjList {
    public String value;
    public int index;
    public List<GraphNodeAdjList> neighbours = new ArrayList<>();

    public GraphNodeAdjList parent;

    public boolean isVisited = false;

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public GraphNodeAdjList(String value, int index) {
        this.value = value;
        this.index = index;
    }
}
