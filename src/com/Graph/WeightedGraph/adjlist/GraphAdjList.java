package src.com.Graph.WeightedGraph.adjlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjList {
    List<GraphNodeAdjList> list;

    public GraphAdjList(List<GraphNodeAdjList> list) {
        this.list = list;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNodeAdjList one = list.get(i);
        GraphNodeAdjList sec = list.get(j);
        one.neighbours.add(sec);
        sec.neighbours.add(one);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            s.append(list.get(i).value + ": ");
            for (int j = 0; j < list.get(i).neighbours.size(); j++) {
                if (j == list.get(i).neighbours.size() - 1) {
                    s.append((list.get(i).neighbours.get(j).value));
                } else {
                    s.append((list.get(i).neighbours.get(j).value) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void bfs() {
        Queue<GraphNodeAdjList> data = new LinkedList<>();
        data.add(list.get(0));
        if (!data.isEmpty()) {
            GraphNodeAdjList removed = data.remove();
            if (!removed.isVisited) {
                System.out.println(removed.value + " ");
                removed.isVisited = true;
            }
            if (removed.neighbours.size() != 0) {
                for (GraphNodeAdjList ind : removed.neighbours) {
                    if (!ind.isVisited()) {
                        data.add(ind);
                    }
                }
            }
        }
    }

    public void addDirectedEdge(int i, int j) {
//        i->j
        GraphNodeAdjList a = list.get(i);
        GraphNodeAdjList b = list.get(i);
        a.neighbours.add(b);
    }

    public void topoAdd(GraphNodeAdjList node, Stack<GraphNodeAdjList> stack) {
        for (GraphNodeAdjList neighbour : node.neighbours) {
            if (!neighbour.isVisited) {
                topoAdd(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.add(node);
    }

    public void topologicalSort() {
        Stack<GraphNodeAdjList> stack = new Stack<>();
        for (GraphNodeAdjList node : list) {
            if (!node.isVisited) {
                topoAdd(node, stack);
            }
        }

        //print the stack
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    //single source shortest path problem

    //using dfs

    public void printParentPath(GraphNodeAdjList node) {
        if (node.parent != null) {
            printParentPath(node.parent);
        }
        System.out.println(node.value + " ");
    }

    public void BFSFSSSPP() {
        Queue<GraphNodeAdjList> queue = new LinkedList<>();
        queue.add(list.get(0));
        while (!queue.isEmpty()) {
            GraphNodeAdjList removed = queue.poll();
            printParentPath(removed);
            if (!removed.isVisited) {
                removed.isVisited = true;
            }
            for (GraphNodeAdjList neighbour : removed.neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.parent = removed;
                }
            }
        }
    }

}
