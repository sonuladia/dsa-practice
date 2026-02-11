package neetcode150;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int start){
        res.add(new ArrayList<>(curr));

        for(int i=start; i<nums.length; i++){
            curr.add(nums[i]);
            backtrack(res, curr, nums, i+1);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets obj = new Subsets();

        int[] nums = {1, 2, 3};

        List<List<Integer>> result = obj.subsets(nums);

        System.out.println("Subsets are:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
