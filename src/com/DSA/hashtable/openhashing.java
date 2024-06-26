package src.com.DSA.hashtable;

import java.util.Iterator;
import java.util.LinkedList;

//separate chaining
public class openhashing {

    LinkedList<Node>[] hashtable;
    int size;

    openhashing(int capacity) {
        hashtable = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            hashtable[i] = new LinkedList<Node>();
        }
        size = 0;
    }

    public int hash(String key) {
        return Math.abs(key.hashCode() % size);
    }

    public void insert(String key) {
        int index = hash(key);
        LinkedList<Node> currentList = hashtable[index];
        //override the value if already present
        for (Node each : currentList) {
            if (each.index == index) {
                each.key = key;
                return;
            }
        }
        //else add to the LL
        currentList.add(new Node(index, key));
        size++;
    }

    public int get(String key) {
        int index = hash(key);
        LinkedList<Node> chain = hashtable[index];
        for (Node node : chain) {
            if (node.key.equals(key)) {
                return node.index;
            }
        }
        return -1;
    }

    public void remove(String key) {
        int index = hash(key);
        LinkedList<Node> chain = hashtable[index];
        Iterator<Node> iterator = chain.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key.equals(key)) {
                iterator.remove();
                size--;
                return;
            }
        }
    }
}
