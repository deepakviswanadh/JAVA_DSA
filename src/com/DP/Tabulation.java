package src.com.DP;

public class Tabulation {
    //bottom-up iteration using tabulation
    public static int fib(int []arr,int n){
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-2]+arr[i-1];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println(fib(new int[n],n));
    }
}
