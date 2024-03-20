package src.com.Graph.WeightedGraph;

import java.util.List;

public class BellmanFord {

    public List<WeightedGraphNode>nodeList;

    BellmanFord(List<WeightedGraphNode> nodeList){
        this.nodeList=nodeList;
    }

    public void BF(WeightedGraphNode source) {
        source.distance = 0;
        int n = nodeList.size();
        int srcIdx = nodeList.indexOf(source);
        relaxation(source);
        //run relaxation n-2 times since source is covered and we do it n-1 times
        for (int i = 0; i < n - 1; i++) {
            if (i != srcIdx) {
                WeightedGraphNode src = nodeList.get(i);
                relaxation(src);
            }
        }
        //check for negative cycle
        for (WeightedGraphNode each : nodeList) {
            for (WeightedGraphNode nei : each.neighbours) {
                if (each.distance + each.weightMap.get(nei) <
                        nei.distance) {
                    //correction needed=>negative cycle
                }
            }
        }
    }

    public void relaxation(WeightedGraphNode source){
        for(WeightedGraphNode neighbour: source.neighbours){
            if(source.distance+source.weightMap.get(neighbour)<
                    neighbour.distance){
                neighbour.distance=source.distance+source.weightMap.get(neighbour);
                neighbour.parent=source;
            }
        }
    }
}
