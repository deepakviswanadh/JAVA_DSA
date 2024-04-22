package src.com.Tree.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    AVLNode root;

    public AVLTree() {
        this.root = null;
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

    public Integer getHeight(AVLNode node) {
        if (node == null) return 0;
        return node.height;
    }

    private AVLNode rotateRight(AVLNode unbalancedNode) {
        AVLNode newRoot = unbalancedNode.left;
        unbalancedNode.left = newRoot.right;
        newRoot.right = unbalancedNode;
        unbalancedNode.height = 1 + Math.max(getHeight(unbalancedNode.left), getHeight(unbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private AVLNode rotateLeft(AVLNode unbalancedNode) {
        AVLNode newRoot = unbalancedNode.right;
        unbalancedNode.right = newRoot.left;
        newRoot.left = unbalancedNode;
        unbalancedNode.height = 1 + Math.max(getHeight(unbalancedNode.left), getHeight(unbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    public Integer getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private AVLNode insertAVLNode(AVLNode node, Integer value) {
        AVLNode newNode = new AVLNode(value);
        if (root == null) {
            root = newNode;
            root.height = 1;
            return root;
        } else if (node == null) {
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

    public void insertIntoAVLTree(Integer value) {
        root = insertAVLNode(root, value);
    }

    public AVLNode getPredecessor(AVLNode node) {
        if (node.right == null) return node;
        return getPredecessor(node.right);
    }

    private AVLNode deleteAVLNode(AVLNode node, Integer value) {
        if (node == null) return null;
            //traversal
        else if (value < node.value) {
            node.left = deleteAVLNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteAVLNode(node.right, value);
        }
        //deletion
        else {
            //node has 2 child
            if (node.left != null && node.right != null) {
                AVLNode preNode = getPredecessor(node.left);
                node.value = preNode.value;
                node.left = deleteAVLNode(node.left, preNode.value);
                return node;
            }
            // node has 1 child
            else if (node.right != null) return node.right;
            else if (node.left != null) return node.left;
                //leaf node
            else {
                return null;
            }
        }
        //rebalancing
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        Integer balance = getBalance(node);
        //LL
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }
        //LR
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        //RL
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        //RR
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }
        return node;
    }

    public void deleteNode(Integer value) {
        root = deleteAVLNode(root, value);
    }
}