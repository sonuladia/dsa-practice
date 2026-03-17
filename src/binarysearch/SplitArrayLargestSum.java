package binarysearch;

import java.util.Arrays;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        SplitArrayLargestSum solver = new SplitArrayLargestSum();

        int[] nums1 = {7, 2, 5, 10, 8};
        int k1 = 2;
        System.out.println("Test 1 Output: " + solver.splitArray(nums1, k1)); // Expected: 18

        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println("Test 2 Output: " + solver.splitArray(nums2, k2)); // Expected: 9

        int[] nums3 = {1, 4, 4};
        int k3 = 3;
        System.out.println("Test 3 Output: " + solver.splitArray(nums3, k3)); // Expected: 4

        int[] nums4 = {2, 3, 1, 2, 4, 3};
        int k4 = 8;
        System.out.println("Test 4 Output: " + solver.splitArray(nums4, k4)); // Expected: -1
    }

    public int splitArray(int[] nums, int k) {
        if ( k > nums.length) return -1;

        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int noOfArrays = findNoOfArrays(nums, mid);
            if (noOfArrays > k)
                low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    private int findNoOfArrays(int[] nums, int k) {
        int arrayCount = 1, sum = 0;
        for (int number : nums) {
            if (sum + number <= k)
                sum = sum + number;
            else {
                arrayCount++;
                sum = number;
            }
        }
        return arrayCount;
    }
}
