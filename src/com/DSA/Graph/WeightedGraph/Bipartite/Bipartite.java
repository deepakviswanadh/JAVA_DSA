package src.com.DSA.Graph.WeightedGraph.Bipartite;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
                //if visited, verify the color from the current node
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
    //variant of Ford Fulkerson
    public int FordFulkersonVariant() {
        int matching = 0;
        for (BipartiteNode node : nodeList) {
            node.setVisited(false);
        }
        //we are performing bfs on the flow network
        //for unvisited & unmatched nodes, we match them and not add to stack
        //as they are neighbours of nodes that are both matched and visited
        //if a node is matched and not visited, we are adding it's matching to stack
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
                            neighbor.visited=true;
                            break;
                            //node is matched and marked visited
                            //no need to explore this
                            //no need to add to bfs
                        } else {
                            //matched and unvisited=>add to bfs
                            queue.offer(neighbor.getMatchedNode());
                        }
                    }
                }
            }
        }
        return matching;
    }

}

