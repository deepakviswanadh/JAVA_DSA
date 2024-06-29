package src.com.DSA.LinkedList.CLL;

public class CLL {
    Node head;
    Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insertEnd(int val) {
        Node n = new Node(val);
        if (head == null) {
            head = n;
            tail = n;
            //in one node list, node must point to itself
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

    public void insertBegin(int val){
        Node n = new Node(val);
        if (head == null) {
            head = n;
            tail = n;
            //in one node list, node must point to itself
            n.next = n;
        }
        else{
            //new node points to the beginning of the ll
            n.next=head;
            //head points to new node
            head=n;
            //last node i.e, tail's next points to new node
            tail.next=n;
        }
    }

    public void insertAtPos(int val, int pos){
        Node n = new Node(val);
        Node temp=head;
        int c=0;
        //need to handle begin and end insertion
        while (c < pos - 1 && temp.next != head) {
            temp = temp.next;
            c++;
        }
        n.next=temp.next;
        temp.next=n;
    }
}
