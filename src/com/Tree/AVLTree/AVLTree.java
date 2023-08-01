package com.Tree.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

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

    public void levelorder() {
        Queue<AVLNode> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            AVLNode removed = temp.remove();
            System.out.print(removed.value + " ");
            if (removed.left != null) {
                temp.add(removed.left);
            }
            if (removed.right != null) {
                temp.add(removed.right);
            }
        }
    }

    public AVLNode rotateRight(AVLNode unbalancedNode) {
        AVLNode newRoot = unbalancedNode.left;
        unbalancedNode.left = newRoot.right;
        newRoot.right = unbalancedNode;
        unbalancedNode.height = 1 + Math.max(getHeight(unbalancedNode.left), getHeight(unbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public AVLNode rotateLeft(AVLNode unbalancedNode) {
        AVLNode newRoot = unbalancedNode.right;
        unbalancedNode.right = newRoot.left;
        newRoot.left = unbalancedNode;
        unbalancedNode.height = 1 + Math.max(getHeight(unbalancedNode.left), getHeight(unbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public Integer getBalance(AVLNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private AVLNode insertAVLNode(AVLNode node, Integer value) {
        if (node == null) {
            AVLNode newNode = new AVLNode(value);
            newNode.height = 1;
            return newNode;
        } else if (value < node.value) {
            node.left = insertAVLNode(node.left, value);
        } else {
            node.right = insertAVLNode(node.right, value);
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
        //RR Rotation
        if (balance < -1 && value > node.right.value) {
            return rotateLeft(node);
        }
        //RL Rotation
        if (balance < -1 && value < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insertIntoAVLTree(Integer value) {
        insertAVLNode(root, value);
    }
}
