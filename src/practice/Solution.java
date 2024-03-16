package src.practice;


import java.util.LinkedList;
import java.util.*;

class GraphNode{
    int val;
    boolean isVisited=false;
    List<GraphNode> neighbours;
}
class Solution {
    public int CountComponents(GraphNode root) {
        Queue<GraphNode>queue= new LinkedList<>();
        queue.add(root);
        int count=0;
        //bfs
        while(!queue.isEmpty()){
            GraphNode removed = queue.poll();
            if(!removed.isVisited){
                removed.isVisited=true;
            }
            for(GraphNode nei:removed.neighbours){
                if(!nei.isVisited){
                    queue.add(nei);
                }
            }
            count++;
        }
        return count;
    }
}