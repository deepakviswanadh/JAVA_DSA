package src.com.DP;

import org.w3c.dom.ls.LSOutput;

public class examples {
    public int climbStairs(int n) {
        int t1 = 1;
        int t2 = 1;
        for (int i = 0; i < n - 1; i++) {
            int s = t1 + t2;
            t2 = t1;
            t1 = s;
        }
        return t1;
    }

    // no of factors of n using some numbers
    // say no of factors of 5 using 1 3 4
    // there are 6 ways
    // 1+ 1 + 1 + 1 + 1 = 5
    // 1 + 1 + 3 = 5
    // 1 + 3 + 1 = 5
    // 3 + 1 + 1 = 5
    // 1 + 4 = 5
    // 4 + 1 = 5
    public static int sumOfFactors(int[] arr, int n, int n1, int n2, int n3) {
        if (n <= 2) return 1;
        if (arr[n] != 0) return arr[n];
        int sum = 1;
        if (n - n1 >= 2) {
            sum += sumOfFactors(arr, n - n1, n1, n2, n3);
        }
        if (n - n2 >= 2) {
            sum += sumOfFactors(arr, n - n2, n1, n2, n3);
        }

        if (n - n3 >= 2) {
            sum += sumOfFactors(arr, n - n3, n1, n2, n3);
        }

        arr[n] = sum;
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n + 1];
        System.out.println(
        sumOfFactors(arr, n, 1, 3, 4));
    }

}
