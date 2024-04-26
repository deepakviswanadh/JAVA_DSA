package src.com.DSA.Tree.RBTree;

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


    public void delete(int data) {
        RBNode node = findNode(data);
        if (node == null) return;
        deleteNode(node);
    }

    private RBNode findNode(int data) {
        RBNode current = root;
        while (current != null) {
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    private void deleteNode(RBNode node) {
        RBNode y = node;
        RBNode x;
        int yOriginalColor = y.color;

        // Deleting a node with at most one child or handling the case with two children
        if (node.left == null) {
            x = node.right;
            transplant(node, node.right);
        } else if (node.right == null) {
            x = node.left;
            transplant(node, node.left);
        } else {
            // Node has two children, use successor to replace it
            y = minimum(node.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == node) {
                if (x != null) x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            }
            transplant(node, y);
            y.left = node.left;
            y.left.parent = y;
            y.color = node.color;
        }

        // Fixing the tree if a black node was removed or moved
        if (yOriginalColor == 0) {
            fixDelete(x);
        }
    }

    private void transplant(RBNode u, RBNode v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }

    private RBNode minimum(RBNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void fixDelete(RBNode x) {
        while (x != root && getColor(x) == 0) {
            if (x == x.parent.left) {
                RBNode w = x.parent.right;
                // Case 1: x's sibling w is red
                if (getColor(w) == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                // Case 2: both of w's children are black
                if (getColor(w.left) == 0 && getColor(w.right) == 0) {
                    w.color = 1;
                    x = x.parent;
                } else {
                    // Case 3: w's right child is black, left is red
                    if (getColor(w.right) == 0) {
                        w.left.color = 0;
                        w.color = 1;
                        rotateRight(w);
                        w = x.parent.right;
                    }
                    // Case 4: w's right child is red
                    w.color = x.parent.color;
                    x.parent.color = 0;
                    w.right.color = 0;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                // Mirror cases for x being a right child
                RBNode w = x.parent.left;
                if (getColor(w) == 1) {
                    w.color = 0;
                    x.parent.color = 1;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if (getColor(w.right) == 0 && getColor(w.left) == 0) {
                    w.color = 1;
                    x = x.parent;
                } else {
                    if (getColor(w.left) == 0) {
                        w.right.color = 0;
                        w.color = 1;
                        rotateLeft(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = 0;
                    w.left.color = 0;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.color = 0; // Ensure root is black
    }

    private int getColor(RBNode node) {
        if (node == null) {
            return 0; // Black by definition
        }
        return node.color;
    }


}
