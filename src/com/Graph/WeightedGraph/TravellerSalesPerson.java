package src.com.Graph.WeightedGraph;

import java.util.Arrays;

//minimum weight hamiltonian path
public class TravellerSalesPerson {

    static int[][] graph;
    static int n;
    static int[][] dp;

    //1<<n meaning

    //shift 1 n times to the left
    //1<<2 => 0001
    //shift 2 times
    //0100 is the result of (1<<2)

    //mask is to indicate which city is visited
    //starting with 1
    static int tsp(int mask, int pos) {
        //all cities visited case

        //lets say we have 4 cities (n=4)
        //we represent them in bitwise as 1111=15(to indicate all are visited)
        //this is = (1<<n)-1 => (10000)-1 =>(16-1)=15
        if (mask == (1 << n) - 1)
            //we are returning edge value of last city to 1st one
            return graph[pos][0];

        //The value of dp[mask][pos] is the minimum cost of visiting all cities
        //ending at city pos.

        if (dp[mask][pos] != -1)
            return dp[mask][pos];

        int minCost = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {
            //mask & (1 << city) will tell if that city in the mask is 0/1
            //0==unvisited
            if ((mask & (1 << city)) == 0) {
                //since now that city is visited, update the mask by making that city's
                //index as 1 by using mask | (1 << city)

                //here graph[pos][city] is the distance from
                // starting(pos) city to the current city (city)
                int newCost = graph[pos][city] + tsp(mask | (1 << city), city);
                minCost = Math.min(minCost, newCost);
            }
        }
        //return the min cost of visiting all cities while memoizing it.
        return dp[mask][pos] = minCost;
    }

    public static void main(String[] args) {
        n = 4;
        graph = new int[][]{
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        //1<<N meaning 2^N. so all combinations of N cities will be considered
        dp = new int[1 << n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int minCost = tsp(1, 0);
        System.out.println("Minimum cost of the TSP tour: " + minCost);
    }
}
