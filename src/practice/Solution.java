package src.practice;

import src.com.Graph.WeightedGraph.WeightedGraphNode;

import javax.swing.*;
import java.util.*;

//prim ->similar to Dijsktra's
class PrimNode implements Comparable<PrimNode>{
    int val;
    List<PrimNode> adjancentList;
    PrimNode parent;
    boolean isVisited;
    HashMap<PrimNode,Integer> weightMap;
    int distance;

    PrimNode(){
        distance=Integer.MAX_VALUE;
    }

    @Override
    public int compareTo(PrimNode o) {
        return this.distance-o.distance;
    }
}

public class Solution
{
    List<PrimNode> nodes;
    public List<PrimNode> prims(){
        PriorityQueue<PrimNode>queue = new PriorityQueue<>();
        queue.offer(nodes.get(0));
        nodes.get(0).distance=0;
        List<PrimNode>result = new LinkedList<>();
        while(!queue.isEmpty()){
            PrimNode removed = queue.poll();
            if(!removed.isVisited){
                removed.isVisited=true;
                result.add(removed);
                for(PrimNode neighbour: removed.adjancentList){
                    if(neighbour.distance>removed.weightMap.get(neighbour)){
                        neighbour.distance= removed.weightMap.get(neighbour);
                        neighbour.parent=removed;
                        queue.remove(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}


//bipartite using coloring

class Node {
    int val;
    List<Node>adjList;
    int color;
    boolean isVisited;
}

class Bipartite{
    List<Node>nodes;

    public boolean isBipartite(){
        Queue<Node>queue = new LinkedList<>();
        queue.add(nodes.get(0));
        nodes.get(0).color=0;
        while(!queue.isEmpty()){
            Node removed = queue.poll();
            if(!removed.isVisited){
                removed.isVisited=true;
            }
            for(Node neighbour: removed.adjList){
                //non visited=>assign anti color
                //visited =>check for color
                if(!neighbour.isVisited){
                    neighbour.color= 1- removed.color;
                    queue.offer(neighbour);
                }
                else {
                    if(neighbour.color==removed.color){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


//bellman ford ->relaxation
//n nodes-> n-1 relaxations
//-ve cycle=>fail

class BFNode {
    int value;
    int distance;
    int index;
    boolean isVisited;
    List<BFNode>adjList;

    BFNode parent;

    HashMap<BFNode,Integer>weightmap;
}

class BF{
    List<BFNode>nodes;
    //n nodes
    //source node
    //n-1 nodes relax
    public boolean detectBG(){
        for (BFNode node : nodes) {
            if (node.index == 0) {
                node.distance = 0;
            } else {
                node.distance = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<nodes.size()-1;i++){
                performRelaxation(nodes.get(i));
        }
        for (BFNode each : nodes) {
            for (BFNode nei : each.adjList) {
                if (each.distance + each.weightmap.get(nei) <
                        nei.distance) {
                    return false;
                }
            }
        }
        return true;
    }

    public void performRelaxation(BFNode node){
        for(BFNode neighbor:node.adjList){
            if(neighbor.distance>node.weightmap.get(neighbor)+node.distance){
                neighbor.distance=node.weightmap.get(neighbor)+node.distance;
                neighbor.parent=node;
            }
        }
    }

}



//floyd warshall


class FL {
    public void FL(int[][] edges, int count) {

        int dist[][] = new int[count][count];

        for (int i = 0; i < count; i++)
            for (int j = 0; j < count; j++)
                dist[i][j] = edges[i][j];

        for (int k = 0; k < count; k++) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}




// m coloring

//is safe
//use color array to keep track of colors of each node using indexes


class mnode{
    int value;
    int index;
    boolean isVisited;
    mnode parent;
    List<mnode>adjList;
}

class mcoloring{
    List<mnode>nodes;

    public boolean isSafe(mnode node, int[]colors, int color){
        for(mnode neighbour: node.adjList){
            if(colors[neighbour.index]==color){
                return false;
            }
        }
        return true;
    }

    public boolean coloring(int color){
        int n= nodes.size();
        int[]colors= new int[n];
        Stack<mnode>stack = new Stack<>();
        stack.push(nodes.get(0));
        while(!stack.isEmpty()){
            mnode removed = stack.pop();
            if(removed.index==n){
                return true;
            }
            boolean isColored=false;
            for(int i=1;i<=color;i++){
                if(isSafe(removed,colors,i)){
                    colors[removed.index]=i;
                    removed.isVisited=true;
                    isColored=true;
                    stack.push(nodes.get(removed.index+1));
                    break;
                }
            }
            if(!isColored){
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    colors[removed.index] = 0;
                }
            }
        }
        return true;
    }
}




//ford fulkerson
class ff{
    int vertices=7;
    public int maxFlow(int[][]graph, int source, int sink){
        int[][]residual = new int[vertices][vertices];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                residual[i][j]=graph[i][j];
            }
        }
        //parent array
        int[]parent = new int[vertices];
        int max=0;
        while(pathExists(source,sink,residual,parent)){
            int u= sink;
            int minpath=Integer.MAX_VALUE;
            //traverse from sink to source and get min
            while(u!=source){
                int v= parent[u];
                minpath=Math.min(minpath,residual[u][v]);
                u=v;
            }
            u= sink;
            while(u!=source){
                int v= parent[u];
                residual[u][v]-=minpath;
                residual[v][u]+=minpath;
                u=v;
            }
            max+=minpath;
        }
        return max;
    }

    public boolean pathExists(int source, int dest, int[][]g, int[]parent){
        Queue<Integer>queue = new LinkedList<>();
        queue.add(source);
        boolean[]visited = new boolean[vertices];
        parent[source]=1;
        visited[source]=true;
        while(!queue.isEmpty()){
            int removed =queue.poll();
            for(int i=0;i<vertices;i++){
                if(!visited[i] && g[removed][i]>0){
                    visited[i]=true;
                    parent[i]=removed;
                    queue.add(i);
                }
            }
        }
        return visited[dest];
    }
}


//tsp
class tsp{
    int n=4;
    int [][]dp;
    public int tsp(int mask, int city){
        if(mask==(1<<n)-1){
            return dp[city][0];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if((mask & (1<<i)) ==0){
                int newCost=dp[city][i]+tsp(mask|1<<city,i);
                min=Math.min(newCost,min);
            }
        }
        return dp[mask][city]=min;
    }
}


//kruskal
class wnode{
    int index;
    int value;
    List<wnode>adj;
    HashMap<wnode,Integer>weightmap;
    boolean isVisited;
    wnode parent;
}

class edge{
    wnode source;
    wnode destination;
    Integer weight;

    edge(wnode s, wnode d, int weight){
        this.source=s;
        this.destination=d;
        this.weight=weight;
    }
}

class kruskal{
    List<wnode>nodes;

    public List<Integer>mst(){
        List<edge> edges= new LinkedList<>();
        List<Integer>result = new LinkedList<>();
        //nodes to edges
        for(wnode node: nodes)
            for(Map.Entry<wnode, Integer> each:node.weightmap.entrySet()){
                edges.add(new edge(node,each.getKey(),each.getValue()));
            }
        UnionFinder uf = new UnionFinder(nodes.size());
        edges.sort((a,b)->a.weight- b.weight);
        for(edge e :edges){
            wnode s= e.source;
            wnode d= e.destination;
            int sf= uf.find(s.index);
            int df= uf.find(d.index);
            if(sf!=df){
                result.add(sf);
                result.add(df);
                uf.union(sf,df);
            }
        }
        return result;
    }
}

class UnionFinder{
    int[]parent;
    UnionFinder(int size){
        parent= new int[size];
    }

    public int find(int index){
        if(parent[index]!=index){
            parent[index]=find(parent[index]);
        }
        return parent[index];
    }

    public void union(int a , int b){
        int ap= find(a);
        int bp=find(b);
        parent[ap]=bp;
    }
}

//red black