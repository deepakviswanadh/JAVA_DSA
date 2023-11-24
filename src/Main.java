import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result= new ArrayList<>();
        HashMap<String, List<String>> data = new HashMap<>();
        for(String each:strs){
            String sorted=sortString(each);
            if(data.containsKey(sorted)){
                List<String> ex1=  data.get(sorted).stream().collect(Collectors.toList());
                ex1.add(each);
                data.put(sorted,ex1);
            }
            else{
                List<String> ex= Arrays.asList(each);
                data.put(sorted,ex);
            }
        }
        for(Map.Entry<String,List<String>>entry:data.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static String sortString(String input){
        return Stream.of(input.split("")).sorted().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}