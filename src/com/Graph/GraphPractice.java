package src.com.Graph;

import java.util.ArrayList;
import java.util.List;

public class GraphPractice {

    public static void main(String[] args) {
        List<GraphNode> data = new ArrayList<>();
        data.add(new GraphNode("A", 0));
        data.add(new GraphNode("B", 1));
        data.add(new GraphNode("C", 2));
        data.add(new GraphNode("D", 3));
        data.add(new GraphNode("E", 4));
        data.add(new GraphNode("F", 5));
        data.add(new GraphNode("G", 6));
        Graph graph = new Graph(data);
//        graph.addUndirectedEdge(0, 1);
//        graph.addUndirectedEdge(0, 2);
//        graph.addUndirectedEdge(1, 0);
//        graph.addUndirectedEdge(1, 3);
//        graph.addUndirectedEdge(2, 0);
//        graph.addUndirectedEdge(2, 3);
//        graph.addUndirectedEdge(3, 4);
//        graph.addUndirectedEdge(3, 5);
//        graph.addUndirectedEdge(4, 3);
//        graph.addUndirectedEdge(5, 3);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(1, 6);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(4, 5);
        graph.addUndirectedEdge(5, 6);


        //System.out.println(graph.toString());

        graph.bfs();
//        graph.dfs();

    }
}
