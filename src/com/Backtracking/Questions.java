package src.com.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Questions {

    //subsets non repeating
    //[1,2,3]->[[],[1],[2],...]
    public List<List<Integer>> subsets(int []arr){
        List<Integer>current = new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        dfs(current,result,0,arr);
        return result;
    }

    public void dfs(List<Integer>current, List<List<Integer>> result,
                    int i, int[]arr){
        if(i>=arr.length-1){
            result.add(new ArrayList<>(current));
            return;
        }
        //add current
        current.add((arr[i]));
        dfs(current,result,i+1,arr);
        //void current (remove last as it gets inserted in the end (array list)
        current.remove(current.size()-1);
        dfs(current,result,i+1,arr);
    }


    //combination sum
    //[2,3,,6,7] , total =7, [2,2,3],[7], repeating allowed
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(0, current, result, candidates, target, 0);
        return result;

    }
    public static void dfs(int i, List<Integer> current, List<List<Integer>> result,
                           int[] c, int target, int total) {
        // Base condition
        if(total==target){
            result.add(new ArrayList<>(current));
            return;
        }
        else if(i>=c.length || total>target){
            return;
        }

        //add current
        current.add(c[i]);
        //keep current index
        dfs(i, current, result, c, target,total+c[i]);

        //remove current
        current.remove(current.size() - 1);
        //move to next index
        dfs(i + 1, current, result, c, target,total);
    }

    //permutate combos
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>current =new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        //convert to array list for easy add and remove
        for (int num : nums) {
            numsList.add(num);
        }
        permuteHelper(numsList, current, result);
        return result;

    }

    private void permuteHelper(List<Integer> nums, List<Integer> current, List<List<Integer>> result) {
        // Base case
        if (nums.size() == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            //remove 1st element
            int num = nums.remove(i);
            //include it in permutation- 1st case
            current.add(num);
            //calculate combos for remaining
            permuteHelper(nums, current, result);
            //exclude it in permutation - 2nd case
            current.remove(current.size() - 1);
            //add it back to its og place after sub permutations are done
            nums.add(i, num);
        }
    }
}
