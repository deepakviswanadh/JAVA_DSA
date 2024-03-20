package src.com.DP;

public class Knapsack {
    public static int ZeroOneKnapSack(int target, int[] weights, int[] prices, boolean[] tracker) {
        int[][] arr = new int[weights.length + 1][target + 1];
        int rows = arr.length;
        int columns = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //1st row and column=0
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                    //if current weight is less than target, consider max of previous [row-1][column]
                    //and [row-1][column]
                    //basically max of top and left values
                } else if (weights[i - 1] <= j) {
                    arr[i][j] = Math.max(arr[i - 1][j], prices[i - 1] + arr[i - 1][j - weights[i - 1]]);
                    if (prices[i - 1] + arr[i - 1][j - weights[i - 1]] > arr[i - 1][j]) {
                        tracker[i - 1] = true;
                    }
                    //if current weight is greater than target, use previous
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        // Return the maximum value that can be obtained from the knapsack
        return arr[weights.length][target];
    }

}
