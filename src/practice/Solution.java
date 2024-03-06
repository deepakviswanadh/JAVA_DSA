package src.practice;

class Solution {
    public String longestPalindrome(String s) {
        int lp=0;
        int rp=1;
        String sub="";
        sub+=s.charAt(lp);
        while(rp<s.length()){
            sub+=s.charAt(rp);
            if(isPalindrome){
                rp++;
            }
            else{
                sub=sub.substring(lp+1);
                lp++;
            }
        }
        return sub;
    }
}