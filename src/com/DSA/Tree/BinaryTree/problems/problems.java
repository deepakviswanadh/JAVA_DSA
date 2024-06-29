package src.com.DSA.Tree.BinaryTree.problems;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
public class problems {


    //max node in a bt
    public int findMax(Node node){
        Queue<Node>queue = new LinkedList<>();
        queue.add(node);
        int max=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node removed = queue.poll();
            max=Math.max(max,removed.value);
            if(removed.left!=null){
                queue.add(removed.left);
            }
            if(removed.right!=null){
                queue.add(removed.right);
            }
        }
        return max;
    }

    //count leaves in a bt
    public int countLeaves(Node node){
        Queue<Node>queue = new LinkedList<>();
        queue.add(node);
        int count=0;
        while(!queue.isEmpty()){
            Node removed = queue.poll();
             if(removed.left==null && removed.right==null){
                count++;
            }
             else {
                 if (removed.left != null) {
                     queue.add(removed.left);
                 } if (removed.right != null) {
                     queue.add(removed.right);
                 }
             }
        }
        return count;
    }

    //height of a bt
    public int findHeight(Node node){
        Queue<Node>queue = new LinkedList<>();
        queue.add(node);
        int height=0;
        while(!queue.isEmpty()){
            int queueSize= queue.size();
            for(int i=0;i<queueSize;i++) {
                Node removed = queue.poll();
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
            }
            height++;
        }
        return height;
    }

}
