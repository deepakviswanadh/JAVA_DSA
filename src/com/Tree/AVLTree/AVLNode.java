package com.Tree.AVLTree;

public class AVLNode {
    public Integer value;
    public Integer height;
    public AVLNode left;
    public AVLNode right;


    AVLNode(Integer value) {
        this.height = 0;
        this.value = value;
        this.left = null;
        this.right = null;
    }


}
