package src.com.Tree.RBTree;

public class RBTree {
    RBNode root;

    RBTree() {
        this.root = null;
    }


    public void rotateLeft(RBNode current){
        //avl way of rotation
//    RBNode newRoot= node.right;
//    node.right=newRoot.left;
//    newRoot.left=node;
//    return newRoot;

        RBNode newRoot = current.right;
        current.right = newRoot.left;
        //if new root has left, its updated parent will the current node
        if (newRoot.left != null)
            newRoot.left.parent = current;
        //new root's parent will be same as current's parent
        newRoot.parent = current.parent;
        //if current's parent is null=> it is root
        if (current.parent == null)
            root = newRoot;
        //if current is it's parent left child
        else if (current == current.parent.left)
            //it will be new parents (new root's) left child
            current.parent.left = newRoot;
        //otherwise , it will be right side
        else
            current.parent.right = newRoot;
        newRoot.left = current;
        //current's parent will be new root
        current.parent = newRoot;

        // Recoloring: Adjust colors of nodes
        newRoot.color = current.color;
        current.color = 1; // Red
    }

    public void rotateRight(RBNode current) {
        RBNode newRoot = current.left;
        current.left = newRoot.right;

        // Update parent pointer of newRoot's right child to current
        if (newRoot.right != null)
            newRoot.right.parent = current;

        // Update parent pointer of newRoot to current's parent
        newRoot.parent = current.parent;

        // Update current's parent's child pointer to newRoot
        if (current.parent == null)
            root = newRoot;
        else if (current == current.parent.right)
            current.parent.right = newRoot;
        else
            current.parent.left = newRoot;

        // Update newRoot's right child to be current
        newRoot.right = current;

        // Update current's parent to be newRoot
        current.parent = newRoot;

        // Recoloring: Adjust colors of nodes
        newRoot.color = current.color;
        current.color = 1; // Red
    }


    public void insertInto(int data) {
        RBNode newNode = new RBNode(data);
        RBNode parentNode = null;
        RBNode current = root;
        //finding the insertion point while keeping track of parent
        while (current != null) {
            parentNode = current;
            if (data < current.data) {
                current = current.left;
            }
            current = current.right;
        }
        //update the parent of the new node
        newNode.parent=parentNode;
        //insert this new node into the parent's left or right
        if(parentNode==null){
            root=newNode;
        }
        if(parentNode.data>newNode.data){
            parentNode.left=newNode;
        }
        else{
            parentNode.right=newNode;
        }
        fixViolation(newNode);
    }

    public void insert(int data) {
        insertInto(data);
    }

    // Fix Red-Black Tree violations after insertion
    private void fixViolation(RBNode node) {
        RBNode parent, grandparent;

        //until we reach root and node and its parent are not red, this loop runs
        while (node != root && node.color == 1 && node.parent.color == 1) {
            parent = node.parent;
            grandparent = parent.parent;

            // Case: Parent is a left child of grandparent
            if (parent == grandparent.left) {
                RBNode uncle = grandparent.right;

                // Case: Uncle is red
                if (uncle != null && uncle.color == 1) {
                    // Recolor the parent, uncle, and grandparent
                    grandparent.color = 1;
                    parent.color = 0;
                    uncle.color = 0;
                    node = grandparent; // Move the node up to the grandparent
                } else {
                    // Case: Uncle is black, node is right child
                    if (node == parent.right) {
                        //move the node to parent and perform left rotation
                        node = parent;
                        rotateLeft(node);
                    }
                    // Case: Uncle is black, node is left child
                    parent = node.parent;
                    grandparent = parent.parent;
                    parent.color = 0;
                    grandparent.color = 1;
                    rotateRight(grandparent); // Perform a right rotation
                }
            } else { // Case: Parent is a right child of grandparent
                RBNode uncle = grandparent.left;

                // Case: Uncle is red
                if (uncle != null && uncle.color == 1) {
                    // Recolor the parent, uncle, and grandparent
                    grandparent.color = 1;
                    parent.color = 0;
                    uncle.color = 0;
                    node = grandparent; // Move the node up to the grandparent
                } else {
                    // Case: Uncle is black, node is left child
                    if (node == parent.left) {
                        node = parent;
                        rotateRight(node); // Perform a right rotation
                    }
                    // Case: Uncle is black, node is right child
                    parent = node.parent;
                    grandparent = parent.parent;
                    parent.color = 0;
                    grandparent.color = 1;
                    rotateLeft(grandparent); // Perform a left rotation
                }
            }
        }
        root.color = 0;
    }


}
