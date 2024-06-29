package src.com.DSA.LinkedList.Stack.Array;

public class Stack {
    int []stack;
    int size;
    //we don't want to use array size as stack size as that is physical & fixed
    //array size cannot be reduced once allocated
    //hence we would create a new variable size to keep the track of the stack size

    public Stack(int size){
        this.stack= new int[size];
        this.size=0;
    }

    //isEmpty
    public boolean isEmpty(){
        return size==0;
    }

    //isFull
    public boolean isFull(){
        return size==stack.length;
    }

    //push
    public void push(int val){
        if(isFull()){
            System.out.println("Full");
            return;
        }else{
            stack[size]=val;
            size++;
        }
    }

    //peek
    public int peek(){
        if(isEmpty())return -1;
        return stack[size-1];
    }

    //pop
    public int pop(){
        if(isEmpty())return -1;
        else{
            int element = stack[size-1];
            size--;
            return element;
        }
    }
}

