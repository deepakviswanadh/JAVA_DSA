package src.com.DSA.Queue.Array;

public class Array {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Array(int capacity) {
        this.array = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }

    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        //% ensures that if rear reaches the end of the array
        // it wraps around to the beginning of the array
        rear = (rear + 1) % capacity;
        array[rear] = data;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        //% ensures that if front reaches the end of the array
        // it wraps around to the beginning of the array
        int data = array[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}
