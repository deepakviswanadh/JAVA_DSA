package practice;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //opposite sides
        if(root==null || ( p.val<=root.val && q.val>=root.val ) || ( p.val>=root.val && q.val<=root.val)){
            return root;
        }
        if(p.val>root.val){
            return lowestCommonAncestor( root.right,  p,  q);
        }
        return lowestCommonAncestor( root.left,  p,  q);


    }

    public static void main(String[] args) {
        System.out.println();
    }
}