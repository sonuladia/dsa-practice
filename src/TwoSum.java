import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 1. Two Sum
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * */
public class TwoSum {

    public static void main(String args[]) {
        int[] nums = {3, 2, 4};

        int[] res = twoSum1(nums, 6);
        boolean output = twoSum2(nums, 6);
        System.out.println("two sum : " + Arrays.toString(res));
        System.out.println("Does two sum exists? " + output);
    }

    private static boolean twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }
        return false;
    }

    private static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int lookingFor = target - nums[i];
            if (temp.containsKey(lookingFor))
                return new int[]{temp.get(lookingFor), i};
            else
                temp.put(nums[i], i);
        }
        return null;
    }
}
