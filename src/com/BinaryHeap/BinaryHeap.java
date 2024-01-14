package src.com.BinaryHeap;

public class BinaryHeap {
    int []arr;
    int heapSize;

    public BinaryHeap(int size){
        arr= new int[size];
        heapSize=0;
    }

    public boolean isHeapEmpty(){
        return heapSize==0;
    }

    public Integer peekHeap(){
        if(!isHeapEmpty()){
            return arr[1];
        }
        return null;
    }

    public void levelOrder(){
        for(int i=1;i<=heapSize;i++){
            System.out.println(arr[i]);
        }
    }

    public void heapifyBottomToTop(int index, String typeOfHeap){
        int parent = index/2;
        //reached top
        if(index<=1)return;
        if(typeOfHeap.equals("min")){
            if(arr[index]<arr[parent]){
                int temp=arr[index];
                arr[index]=arr[parent];
                arr[parent]=temp;
            }
        }
        else if(typeOfHeap.equals("max")){
            if(arr[index]>arr[parent]){
                int temp=arr[index];
                arr[index]=arr[parent];
                arr[parent]=temp;
            }
        }
        heapifyBottomToTop(parent,typeOfHeap);
    }

    public void insertIntoHeap(int value,String type){
        arr[heapSize++]=value;
        heapifyBottomToTop(heapSize,type);
        levelOrder();
    }
}
