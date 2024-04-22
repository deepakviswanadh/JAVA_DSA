package src.com.DP;

import java.util.Arrays;

public class Memoization {
    //top-down memoization using recursion
    public static int fib(int n, int[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }
        if (n <= 1) return n;
        arr[n] = fib(n - 1, arr) + fib(n - 2, arr);
        return arr[n];
    }

    public static void main(String[] args) {
        int n = 10;
        //n+1 size is needed to store 0 to n values inclusive
        //1st element is accessed at 0 index
        //2nd->1 .... n+1
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        System.out.println("fib is " + fib(n, arr));
    }
}