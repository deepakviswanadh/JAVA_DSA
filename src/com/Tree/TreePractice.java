package com.Tree;

import com.Tree.BinarySeachTree.BinarySearchTree;
import com.Tree.BinaryTree.BinaryNode;
import com.Tree.BinaryTree.BinaryTree;
import com.Tree.TreeNode.TreeNode;

public class TreePractice {
    public static void printBinaryTreePractice() {
//        BinaryTree newTree = new BinaryTree();
//        newTree.insert("N1");
//        newTree.insert("N2");
//        newTree.insert("N3");
//        newTree.insert("N4");
//        newTree.insert("N5");
//        newTree.insert("N6");
//        newTree.levelorder();
//        newTree.deleteNode("N4");
//        newTree.levelorder();

        BinarySearchTree temp = new BinarySearchTree();
        temp.insertIntoBST(70);
        temp.insertIntoBST(50);
        temp.insertIntoBST(90);
        temp.insertIntoBST(30);
        temp.insertIntoBST(60);
        temp.insertIntoBST(80);
        temp.insertIntoBST(100);
        temp.insertIntoBST(20);
        temp.insertIntoBST(40);
        temp.insertIntoBST(110);
        temp.preorder(temp.root);
        temp.deleteBinarySeachTreeNode(temp.root, 40);
        System.out.println();
        temp.preorder(temp.root);
    }
}