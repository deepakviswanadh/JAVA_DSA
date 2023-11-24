package examples;

import com.sun.tools.javac.util.Convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
    public void examples(){

//        Sort string alphabetically
        String s="cba";
        Stream.of(s.split(""))
                .sorted()
                .collect(Collectors.joining());


//        Detect string data has any duplicates
        String data1 = "hello";
        boolean hasDuplicates = data1.chars().distinct().count() != data1.length();

//        Convert int[] data->List<>Integer
        int[]data = new int[]{1,2,3,4};

        Arrays.stream(data).boxed().collect(Collectors.toList());


//        Convert List<>Integer data to int[]

        List<Integer> data2 = new ArrayList<>();

        data2.stream().mapToInt(i -> i).toArray();


    }

}
