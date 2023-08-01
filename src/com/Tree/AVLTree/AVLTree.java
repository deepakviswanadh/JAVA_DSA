package com.Tree.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    AVLNode root;

    // Constructor
    public AVLTree() {
        root = null;
    }


    // Level Order
    public void levelOrder() {
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AVLNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }


    //  getHeight
    public Integer getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private AVLNode rotateRight(AVLNode disbalancedNode) {
        AVLNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private AVLNode rotateLeft(AVLNode disbalancedNode) {
        AVLNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public Integer getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // insertNode Method
    private AVLNode insertNode(AVLNode node, Integer value) {
        AVLNode newNode = new AVLNode(value);
        if (root == null) {
            root = newNode;
            root.height = 1;
            return root;
        } else if (node == null) {
            newNode.height = 1;
            return newNode;
        } else if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else {
            node.right = insertNode(node.right, value);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        Integer balance = getBalance(node);

        //LL Rotation
        if (balance > 1 && value < node.left.value) {
            return rotateRight(node);
        }
        //LR Rotation
        if (balance > 1 && value > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        //RL Rotation
        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        //RR Rotation
        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(Integer value) {
        root = insertNode(root, value);
    }
}
