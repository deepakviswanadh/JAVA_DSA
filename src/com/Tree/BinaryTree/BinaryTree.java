package com.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    BinaryNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void preorder(BinaryNode node) {
        if (node == null) return;
        System.out.println(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(BinaryNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.value + " ");
        inorder(node.right);
    }

    public void postorder(BinaryNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value + " ");
    }

    public void levelorder() {
        Queue<BinaryNode> temp = new LinkedList<BinaryNode>();
        temp.add(root);
        while (!temp.isEmpty()) {
            BinaryNode removed = temp.remove();
            System.out.print(removed.value + " ");
            if (removed.left != null) {
                temp.add(removed.left);
            }
            if (removed.right != null) {
                temp.add(removed.right);
            }
        }
        System.out.println("\n");
    }

    public void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryNode removed = queue.poll();
                System.out.print(removed.value + " ");
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
            }
            level++;
        }
    }

    //insert into binary tree
    public void insert(String value) {
        Queue<BinaryNode> temp = new LinkedList<BinaryNode>();
        BinaryNode newNode = new BinaryNode(value);
        if (root == null) {
            root = newNode;
            return;
        }
        temp.add(root);
        while (!temp.isEmpty()) {
            BinaryNode removed = temp.remove();
            if (removed.left == null) {
                removed.left = newNode;
                break;
            } else if (removed.right == null) {
                removed.right = newNode;
                break;
            } else {
                temp.add(removed.left);
                temp.add(removed.right);
            }
        }
    }

    //find deepest node
    public BinaryNode findDeepestNode() {
        Queue<BinaryNode> temp = new LinkedList<BinaryNode>();
        temp.add(root);
        BinaryNode removed = null;
        while (!temp.isEmpty()) {
            removed = temp.remove();
            if (removed.left != null) {
                temp.add(removed.left);
            }
            if (removed.right != null) {
                temp.add(removed.right);
            }
        }
        return removed;
    }

    //delete deepest node
    public void deleteDeepestNode() {
        Queue<BinaryNode> temp = new LinkedList<BinaryNode>();
        temp.add(root);
        BinaryNode previous, present = null;
        while (!temp.isEmpty()) {
            previous = present;
            present = temp.remove();
            if (present.left == null) {
                previous.right = null;
                return;
            } else if (present.right == null) {
                present.left = null;
                return;
            } else {
                temp.add(present.left);
                temp.add(present.right);
            }
        }
    }

    //delete a node
    public void deleteNode(String value) {
        Queue<BinaryNode> temp = new LinkedList<BinaryNode>();
        temp.add(root);
        while (!temp.isEmpty()) {
            BinaryNode present = temp.remove();
            if (present.value == value) {
                present.value = findDeepestNode().value;
                deleteDeepestNode();
                return;
            } else {
                if (present.left != null) {
                    temp.add(present.left);
                }
                if (present.right != null) {
                    temp.add(present.right);
                }
            }
        }
    }
}
