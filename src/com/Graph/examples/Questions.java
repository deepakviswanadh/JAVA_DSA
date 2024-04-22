package src.com.Graph.examples;

import java.util.*;

public class Questions {

    public void validPath(int[][] edges) {
        //creating adj list for nodes basing on edges
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
    }

    //count number of connected components in an undirected graph
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) return 0;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(adjList.keySet().iterator().next());

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;
            }
            for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
            count++;
        }
        return count;
    }


    //detect cycle in an undirected graph
    public boolean detectCycle(Map<Integer, List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(adjList.keySet().iterator().next());
        Set<Integer> visited = new HashSet<>();
        //bfs
        while (!queue.isEmpty()) {
            Integer removed = queue.poll();
            if (visited.contains(removed)) {
                return true;
            }
            visited.add(removed);
            for (Integer nei : adjList.get(removed)) {
                if (!visited.contains(nei)) {
                    queue.add(nei);
                } else if (visited.contains(nei) && nei != removed) {
                    return true;
                }
            }
        }
        return false;
    }


    //detect cycle in a directed graph
    public boolean hasCycle(Map<Integer, List<Integer>> adjList) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inProcess = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(adjList.keySet().iterator().next());

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            inProcess.add(current);
            for (int neighbor : adjList.get(current)) {
                if (inProcess.contains(neighbor)) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
            inProcess.remove(current);
        }
        return false;
    }


    //find min of edges b/w source and all nodes (unweighted)
    public int minEdgesBetweenNodes(Map<Integer, List<Integer>> adjList, int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distance = new HashMap<>();
        queue.offer(src);
        distance.put(src, 0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int dist = distance.get(node);

            if (node == dest)
                return dist;

            for (int neighbor : adjList.get(node)) {
                if (!distance.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    //neigh distance = current node's distance +1
                    //ensures we are tracking min distance
                    //due ot bfs properties
                    distance.put(neighbor, dist + 1);
                }
            }
        }
        return -1;
    }


    //topological sort for directed acyclic graph

    public void topoInner(Integer ind, Map<Integer, List<Integer>> adjList, Set<Integer>visited, List<Integer> indList, Stack<Integer>stack){
        for(Integer each:indList){
            if(!visited.contains(each)){
                topoInner(each, adjList,visited,adjList.get(each),stack);
            }
            visited.add(ind);
            stack.push(ind);
        }
    }
    public void topoSort(Map<Integer, List<Integer>> adjList){
        Set<Integer>visited= new HashSet<>();
        Stack<Integer>stack = new Stack<>();
        for(Map.Entry<Integer,List<Integer>>each:adjList.entrySet()){
            if(!visited.contains(each.getKey())){
                topoInner(each.getKey(),adjList,visited,each.getValue(),stack);
            }
        }
    }
}
