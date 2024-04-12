package src.com.LinkedList.Queue.SLL;

public class Queue {
    Node head;
    //fix the head at the beginning of the list
    //move tail as we add new elements
    //1
    //2<-1
    //3<-2<-1
    Node tail;

    Queue(){
        this.head=null;
        this.tail=null;
    }

    //isEmpty
    public boolean isEmpty(){
        return head==null && tail==null;
    };

    //offer
    public void offer(int val){
        Node node = new Node(val);
        if(isEmpty()){
          head=node;
          tail=node;
          return;
        }
        else{
            tail.next=node;
            tail=node;
        }
    }

    //peek
    public int peek(){
        if(isEmpty())return -1;
        return head.val;
    }

    //poll
    public int poll(){
        if(isEmpty())return -1;
        int val=head.val;
        //1 element case
        if(head==tail){
            head=null;
            tail=null;
        }
        else{
            head=head.next;
        }
        return val;
    }
}
