package com.Graph;

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
        list.get(0).setVisited(true);
        if (!data.isEmpty()) {
            GraphNodeAdjList removed = data.remove();
            System.out.println(removed.value + " ");
            if (removed.neighbours.size() != 0) {
                for (GraphNodeAdjList ind : removed.neighbours) {
                    if (!ind.isVisited()) {
                        data.add(ind);
                        ind.setVisited(true);
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


}
