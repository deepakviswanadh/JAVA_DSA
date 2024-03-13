package src.com.Tree.RBTree;

public class RBNode {
    int data;
    RBNode left;
    RBNode right;
    //0->black
    //1->red
    int color;
    RBNode parent;

    RBNode(int data){
        this.data=data;
        //default red
        this.color=1;
    }

}
