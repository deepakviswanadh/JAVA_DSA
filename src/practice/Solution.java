package practice;

class Solution {
<<<<<<< Updated upstream
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //opposite sides
        if(root==null || ( p.val<=root.val && q.val>=root.val ) || ( p.val>=root.val && q.val<=root.val)){
            return root;
        }
        if(p.val>root.val){
            return lowestCommonAncestor( root.right,  p,  q);
        }
        return lowestCommonAncestor( root.left,  p,  q);


=======
    public static int lengthOfLongestSubstring(String s) {
       //S = "aaaabbaa"
        StringBuilder temp = new StringBuilder();
        int l=0;
        int r=0;
        int max=0;
        while(r<s.length()){
            temp=temp.append(s.charAt(r));
            //increase window
            String og= new StringBuilder(temp).toString();
            String reversed=temp.reverse().toString();
            if(!og.equals(reversed)){
                //move left
                max= Math.max(max,temp.length());
                temp=new StringBuilder(temp.substring(l+1));
                l++;
            }
            r++;
        }
        return max;
>>>>>>> Stashed changes
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aaaabbaa"));
    }
}