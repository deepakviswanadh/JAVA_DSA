package src.com.Graph.examples;

import src.com.Graph.GraphNodeAdjList;
import java.util.*;

public class Examples {

    public void validPath(int[][] edges) {
        //creating adj list for nodes basing on edges
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
    }

    //count number of connected components in an undirected graph (non leetcode way)
    public int CountComponents(GraphNodeAdjList root) {
        Queue<GraphNodeAdjList>queue= new LinkedList<>();
        queue.add(root);
        int count=0;
        //bfs
        while(!queue.isEmpty()){
            GraphNodeAdjList removed = queue.poll();
            if(!removed.isVisited){
                removed.isVisited=true;
            }
            for(GraphNodeAdjList nei:removed.neighbours){
                if(!nei.isVisited){
                    queue.add(nei);
                }
            }
            count++;
        }
        return count;
    }

    //detect cycle in a undireted graph
    public boolean detectCycle (GraphNodeAdjList root){
        Queue<GraphNodeAdjList>queue= new LinkedList<>();
        queue.add(root);
        int count=0;
        //bfs
        while(!queue.isEmpty()){
            GraphNodeAdjList removed = queue.poll();
            if(!removed.isVisited){
                removed.isVisited=true;
            }
            else if(removed.isVisited){
                return true;
            }
            for(GraphNodeAdjList nei:removed.neighbours){
                if(!nei.isVisited){
                    queue.add(nei);
                }
                else if(nei.isVisited && nei!=removed){
                    return true;
                }
            }
        }
        return false;
    }
}
