import java.util.HashMap;
import java.util.Map;

/*
* 560. Subarray Sum Equals K
* Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
* A subarray is a contiguous non-empty sequence of elements within an array.
* */

public class SubarraySumEqualsK {

    public static void main(String args[]) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int res = subarraySum(nums, k);
        System.out.println("Count of subarrays with sum k : " + res);
    }

    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0, cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            int remove = preSum - k;
            if (map.containsKey(remove)) {
                cnt = cnt + map.get(remove);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}
