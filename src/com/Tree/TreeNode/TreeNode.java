package com.Tree.TreeNode;

import java.util.ArrayList;

public class TreeNode {
    String TreeData;
    ArrayList<TreeNode> children;

    public TreeNode(String treeData) {
        this.TreeData = treeData;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChildren(TreeNode childNode){
        this.children.add(childNode);
    }

    public  String printTree(int level){
        String constructData = "  ".repeat(level)+TreeData+"\n";
        for(TreeNode treeNode: children){
            constructData+=treeNode.printTree(level+1);
        }
        return constructData;
    }
}
