package src.com.BinaryHeap;

public class BinaryHeap {
    int arr[];
    int sizeOfTree;

    public BinaryHeap(int size) {
        //this +1 size is needed as 0 index is left out for math simplicity
        arr = new int[size+1];
        this.sizeOfTree = 0;
    }

    public boolean isEmpty() {
       return sizeOfTree==0;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Binary Heap is Empty");
            return null;
        }
        return arr[1];
    }

    public void levelOrder() {
        for (int i =1; i<=sizeOfTree; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    public void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1 ) {
            return;
        }
        if (heapType.equalsIgnoreCase("Min")) {
            if (arr[index] < arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        } else if (heapType.equalsIgnoreCase("Max")) {
            if (arr[index] > arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String typeHeap) {
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, typeHeap);
        System.out.println("Inserted " +value+ " successfully in Heap");
        levelOrder();
    }

    // heapifyTopToBottom
    public void heapifyTopToBottom(int index, String heapType) {
        int left = index*2;
        int right = index*2 + 1;
        //current swap
        int swapChild = index;
        //nothing left
        if (sizeOfTree < left) {
            return;
        }
        //max heap
        if (heapType.equalsIgnoreCase("Max")) {
            //1 child case
            if (sizeOfTree == left) {
                if (arr[index] < arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                    heapifyTopToBottom(left, heapType);
                }
            } else {
                //2 child case, chose the highest
                if (arr[left]>arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                //swap
                if (arr[index] < arr[swapChild]) {
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                    heapifyTopToBottom(swapChild, heapType);
                }
            }
        } else if (heapType.equalsIgnoreCase("Min")) {
            if (sizeOfTree == left) {
                if (arr[index] > arr[left]) {
                    int tmp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = tmp;
                    heapifyTopToBottom(left, heapType);
                }
            } else {
                if (arr[left] < arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] > arr[swapChild]) {
                    int tmp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = tmp;
                    heapifyTopToBottom(swapChild, heapType);
                }
            }
        }
    }

    public int extractHeadOfBP(String heapType) {
        if (isEmpty()) {
            return -1;
        } else {
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }

    // delete
    public void deleteBH() {
        arr = null;
        System.out.println("BH has been successfully deleted");
    }

}
