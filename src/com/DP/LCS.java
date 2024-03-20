package src.com.DP;

public class LCS {
    //abcde ace
    //find length of longest common subsequence

    public static int LCS(String s1,String s2) {
        //initialize 2d array of size [s1+1][s2+1]
        int[][]arr = new int[s1.length()+1][s2.length()+1];
        //bottom up approach
        for(int i=s1.length()-1;i>=0;i--){
            for(int j=s2.length()-1;j>=0;j--){
                //if equal, 1+its below diagonal value
                if(s1.charAt(i)==s2.charAt(j)){
                    arr[i][j]=1+arr[i+1][j+1];
                }
                //max of right, left
                else{
                    arr[i][j]=Math.max(arr[i][j+1],arr[i+1][j]);
                }
            }
        }
        return arr[0][0];
    }
}
