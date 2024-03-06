package src.com.LinkedList.CLL;

public class CLL {
    Node head;
    Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
            tail = n;
            n.next = n;
        }
        else {
            //old tail has end node, make it point to new node making the
            //new node as the end node
            tail.next=n;
            //tail points to new node now
            tail=n;
            //new node's next points to head, completing the circle
            n.next=head;
        }
    }
}
