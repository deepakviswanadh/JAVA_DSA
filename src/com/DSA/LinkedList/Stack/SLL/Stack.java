package src.com.DSA.LinkedList.Stack.SLL;


//while writing the stack using LL, add nodes towards left
// suppose we have 1
//we want to add 2
// 2->1 is the way
//not 1->2
//this will ensure that tracking back to previous elements will be easy(head=head.next)
public class Stack {

    //track the top of the stack
    Node head;

    Stack(){
        head=null;
    }


    public boolean isEmpty(){
        return head==null;
    }

    //push
    public void insert(int val){
        Node node = new Node(val);
        if(isEmpty()){
            head=node;
            return;
        }
        else{
            //head is pointing to the top element
            //2
            //inserting 1
            //1->2
            //1.next is 2 (current head)
            //1 is top of the stack=>update head to 1(new head)
            //now update head to new node
            node.next = head;
            head = node;
        }
    }


    //peek
    public int peek(){
        //empty check
        if(isEmpty()){
            return -1;
        }
        else{
            return head.val;
        }
    }

    //pop
    public int pop(){
        int headVal = peek();

        // Empty stack check
        if(isEmpty()){
            return -1;
        }

        if (head.next == null) {
            head = null; // Set head to null as the stack becomes empty
        } else {
            head = head.next; // Move head to the next node
        }

        return headVal;
    }


}
