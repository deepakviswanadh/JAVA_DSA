package src.com.Queue.problems;

import java.util.Queue;

public class problem {

    //josephus recursion
    public int josephus(int n, int k){
        if(n==1){
            return 1;
        }
        return (josephus(n-1,k)+k-1)%n+1;
    }

    //josephus queue
    public int josephusQueue(int n , int k, Queue<Integer>queue){
        //k-1 dequeue and queue to end
        //dequeue 1st element

        while(queue.size()>1){
            for(int i=0;i<k-1;i++){
                int ele= queue.poll();
                queue.offer(ele);
            }
            queue.poll();
        }
        //1 element is remaining, return it
        return queue.poll();
    }

}
