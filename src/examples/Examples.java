package src.examples;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
    public void examples() {

//        Sort string alphabetically
        String s = "cba";
        Stream.of(s.split(""))
                .sorted()
                .collect(Collectors.joining());


//        Detect string data has any duplicates
        String data1 = "hello";
        boolean hasDuplicates = data1.chars().distinct().count() != data1.length();

//        Convert int[] data->List<>Integer
        int[] data = new int[]{1, 2, 3, 4};

        Arrays.stream(data).boxed().collect(Collectors.toList());


//        Convert List<>Integer data to int[]

        List<Integer> data2 = new ArrayList<>();

        data2.stream().mapToInt(i -> i).toArray();

    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    private static void permute(char[] str, int currentIndex) {
        if (currentIndex == str.length - 1) {
            System.out.println(String.valueOf(str));
        }

        for (int i = currentIndex; i < str.length; i++) {
            swap(str, currentIndex, i);
            permute(str, currentIndex + 1);
            swap(str, currentIndex, i);
        }
    }


    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        towerOfHanoi(numberOfDisks, 'A', 'C', 'B');
    }


//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> data = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            data.put(i, data.getOrDefault(i, 0) + 1);
//        }
//        Collections.sort(data, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
//    }
}

