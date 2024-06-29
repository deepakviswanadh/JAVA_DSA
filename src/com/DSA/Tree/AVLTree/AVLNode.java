package src.com.DSA.Tree.AVLTree;

public class AVLNode {
    public Integer value;
    public AVLNode left;
    public AVLNode right;
    public Integer height;

    public AVLNode(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
}
