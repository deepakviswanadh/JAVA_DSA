package com.Tree.AVLTree;

public class AVLTree {
    AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    public Integer getHeight(AVLNode node) {
        if (node == null) return 0;
        else {
            return node.height;
        }
    }

    public AVLNode rotateRight(AVLNode unbalancedNode) {
        AVLNode newRoot = unbalancedNode.right;
        unbalancedNode.left = newRoot.right;
        newRoot.right = unbalancedNode;
        unbalancedNode.height = 1 + Math.max(getHeight(unbalancedNode.left), getHeight(unbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public AVLNode rotateLeft(AVLNode unbalancedNode) {
        AVLNode newRoot = unbalancedNode.left;
        unbalancedNode.right = newRoot.left;
        newRoot.left = unbalancedNode;
        unbalancedNode.height = 1 + Math.max(getHeight(unbalancedNode.left), getHeight(unbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }
}
