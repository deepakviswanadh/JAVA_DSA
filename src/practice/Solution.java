package src.practice;


import src.com.Graph.GraphNodeAdjList;

import java.util.LinkedList;
import java.util.*;

class Solution {
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
}