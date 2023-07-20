package com.Tree.BinarySeachTree;

import com.Tree.BinaryTree.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public BinarySearchTreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    private BinarySearchTreeNode insertNode(BinarySearchTreeNode currentNode, Integer value) {
        BinarySearchTreeNode newNode = new BinarySearchTreeNode(value);
        if (root == null) {
            root = newNode;
            return root;
        }
        if (currentNode == null) {
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insertNode(currentNode.left, value);
        } else {
            currentNode.right = insertNode(currentNode.right, value);
        }
        return currentNode;
    }

    public void insertIntoBST(Integer value) {
        insertNode(root, value);
    }

    public void preorder(BinarySearchTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(BinarySearchTreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    public void postorder(BinarySearchTreeNode node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelorder() {
        Queue<BinarySearchTreeNode> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            BinarySearchTreeNode removed = temp.remove();
            System.out.print(removed.value + " ");
            if (removed.left != null) {
                temp.add(removed.left);
            }
            if (removed.right != null) {
                temp.add(removed.right);
            }
        }
    }

    public BinarySearchTreeNode searchBinarySearchTree(BinarySearchTreeNode root, Integer value) {
        if (root == null) return null;
        else if (root.value == value) return root;
        else {
            if (value < root.value) {
                return searchBinarySearchTree(root.left, value);
            } else return searchBinarySearchTree(root.right, value);
        }
    }

    public BinarySearchTreeNode findSuccessor(BinarySearchTreeNode node) {
        if (node.right == null) return node;
        else {
            return findSuccessor(node.right);
        }
    }


    public BinarySearchTreeNode deleteBinarySeachTreeNode(BinarySearchTreeNode root, Integer value) {
        if (root == null) return null;
        if (value < root.value) {
            root.left = deleteBinarySeachTreeNode(root.left, value);
            return root;
        } else if (value > root.value) {
            root.right = deleteBinarySeachTreeNode(root.right, value);
            return root;
        }
        
        //case: both child exists
        if (root.right != null && root.left != null) {
            BinarySearchTreeNode nodeSuccessor = findSuccessor(root.left);
            root.value = nodeSuccessor.value;
            root.left = deleteBinarySeachTreeNode(root.left, nodeSuccessor.value);
            return root;
        }
        // case: it has one child
        // left child
        else if (root.left != null) {
            return root.left;
        }
        //right child
        else if (root.right != null) {
            return root.right;
        }
        //no child
        else {
            return null;
        }
    }
}
