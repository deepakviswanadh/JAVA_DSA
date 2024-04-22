package src.com.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class problems {

    //maximum length consecutive subarray

    public int MLCS(int []arr){
        int size=Integer.MIN_VALUE;
        HashSet<Integer>set = new HashSet<>();
        set.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        for(Integer i:set){
            //check if predecessor value is not present
            //lets say for 1 , 0 should not be in set
            //then we can start from 1 (1,2,3....)
            //if not present=>it will be starting value
            if(!set.contains(i-1)){
                int temp =i;
                //keep incrementing in steps of 1 till each element is in set
                while(set.contains(temp)) {
                    temp++;
                }
                size=Math.max(size,temp-i);
            }
        }
        return size;
    }
}
