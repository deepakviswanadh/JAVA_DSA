package src.com.DSA.Graph.WeightedGraph;
class FloydWarshall {

     void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        //relaxation
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        //detect negative cycle
        detectNegativeCycles(dist,V);
    }

    public boolean detectNegativeCycles(int [][]dist, int V){

        //since diagonal elements are edges to themselves, if there is a cycle
        //this will be -ve (cycle starts and ends at that node (1-2-3-4-1)

        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                return true;
            }
        }
        return false;
    }

}
