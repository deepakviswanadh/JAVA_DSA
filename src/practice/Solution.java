package practice;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        String res = "";
        for (int i = 0; i < k; i++) {
            res += s2.charAt(i);
        }
        res = Stream.of(res.split(""))
                .sorted()
                .collect(Collectors.joining());
        s1 = Stream.of(s1.split(""))
                .sorted()
                .collect(Collectors.joining());
        if (s1.equals(res)) return true;
        for (int i = k; i < s2.length(); i++) {
            res = res + s2.charAt(i);
            res = res.substring(1);
            String temp = "";
            temp = Stream.of(res.split(""))
                    .sorted()
                    .collect(Collectors.joining());
            System.out.println(temp);
            System.out.println(s1);
            if (temp.equals(s1))
                return true;
            temp = "";
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcba"));
    }

}