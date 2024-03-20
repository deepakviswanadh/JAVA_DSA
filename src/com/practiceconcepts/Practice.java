package src.com.practiceconcepts;

import src.com.BinaryHeap.BinaryHeap;


public class Practice {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(4);
        heap.insert(10,"min");
        heap.insert(5,"min");
        heap.insert(15,"min");
        heap.insert(9,"min");

        heap.extractHeadOfBP("min");
        heap.levelOrder();
    }
}
