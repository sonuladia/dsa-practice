package leetcodeblind75;

import java.util.HashMap;
import java.util.Map;

public class MaxNoOfKSumPairs {

    public static void main(String[] args) {
        MaxNoOfKSumPairs solver = new MaxNoOfKSumPairs();

        int[] nums1 = {1,2,3,4};
        int k1 = 5;
        System.out.println("Test 1: " + solver.maxOperations(nums1, k1)); // Expected: 2

        int[] nums2 = {3,1,3,4,3};
        int k2 = 6;
        System.out.println("Test 2: " + solver.maxOperations(nums2, k2)); // Expected: 1

        int[] nums3 = {2,2,2,2};
        int k3 = 4;
        System.out.println("Test 3: " + solver.maxOperations(nums3, k3)); // Expected: 2

        int[] nums4 = {1,1,1,1,1};
        int k4 = 2;
        System.out.println("Test 4: " + solver.maxOperations(nums4, k4)); // Expected: 2
    }

    public int maxOperations(int[] nums, int k) {
        int maxOps = 0 ;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            int target = k-num;
            if(freq.getOrDefault(target,0) > 0){
                maxOps++;
                freq.put(target, freq.get(target)-1);
            }
            else
                freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        return maxOps;
    }
}
