package com.Tree;

import com.Tree.AVLTree.AVLTree;
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

//        BinarySearchTree temp = new BinarySearchTree();
//        temp.insertIntoBST(70);
//        temp.insertIntoBST(50);
//        temp.insertIntoBST(90);
//        temp.insertIntoBST(30);
//        temp.insertIntoBST(60);
//        temp.insertIntoBST(80);
//        temp.insertIntoBST(100);
//        temp.insertIntoBST(20);
//        temp.insertIntoBST(40);
//        temp.insertIntoBST(110);
//        temp.insertIntoBST(55);
//        temp.levelorder();
//        System.out.println();
//        temp.searchBinarySearchTree(temp.root, -10);
//        temp.deleteBinarySeachTreeNode(temp.root, 60);
//        System.out.println();
//        temp.levelorder();

        AVLTree newAvl = new AVLTree();
        newAvl.insertIntoAVLTree(5);
        newAvl.insertIntoAVLTree(10);
        newAvl.insertIntoAVLTree(15);
        newAvl.insertIntoAVLTree(20);
        newAvl.levelorder();
    }
}
