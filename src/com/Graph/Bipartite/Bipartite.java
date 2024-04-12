package src.com.Graph.Bipartite;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Bipartite {

    List<BipartiteNode> nodeList;

    public Bipartite(List<BipartiteNode> list) {
        this.nodeList = list;
    }

    public boolean isBipartite() {
        Queue<BipartiteNode> queue = new LinkedList<>();
        nodeList.get(0).setColor(0);
        queue.add(nodeList.get(0));
        while (!queue.isEmpty()) {
            BipartiteNode removed = queue.poll();
            if (!removed.isVisited()) {
                removed.setVisited(true);
            }
            for (BipartiteNode node : removed.getNeighbours()) {
                if (!node.visited) {
                    queue.add(node);
                    node.setColor(1 - removed.getColor());
                }
                //if visited, verify the color from its parent/neighbour
                //if they match, its an odd degree cycle
                else {
                    if (removed.getColor() == node.getColor()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    //maximum matching (maximum flow)
    public int FordFulkerson() {
        int matching = 0;
        for (BipartiteNode node : nodeList) {
            node.setVisited(false);
        }
        //we are performing dfs on the flow network
        //for only unvisited/unmatched nodes
        //if a node is matched, we are not adding it to stack
        Queue<BipartiteNode> queue = new LinkedList<>();
        queue.offer(nodeList.get(0));
        while (!queue.isEmpty()) {
            BipartiteNode currentNode = queue.poll();
            if (!currentNode.isVisited()) {
                currentNode.setVisited(true);
                for (BipartiteNode neighbor : currentNode.getNeighbours()) {
                    if (!neighbor.isVisited()) {
                        if (neighbor.getMatchedNode() == null) {
                            currentNode.setMatchedNode(neighbor);
                            neighbor.setMatchedNode(currentNode);
                            matching++;
                            break;
                            //node is matched, no need to explore this
                            //no need to add to dfs
                        } else {
                            queue.offer(neighbor.getMatchedNode());
                        }
                    }
                }
            }
        }
        return matching;
    }

}

