package src.com.Queue.Pointer;

public class CLL {
    private Node front;
    private Node rear;

    public CLL() {
        this.front = null;
        this.rear = null;
    }
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            //rear has ref of current last node
            //rear.next makes current last node point to new node
            //which will make new node as the new last node
            rear.next = newNode;
        }
        //make rear point to new last node
        //make new last node's next point to front,completing the circle
        rear = newNode;
        rear.next = front;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
