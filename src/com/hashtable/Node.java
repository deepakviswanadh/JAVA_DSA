package src.com.hashtable;

class Node{
    int index;
    Node next;

    String key;

    Node(int index, String key){
        this.index=index;
        this.next=null;
        this.key=key;
    }
}