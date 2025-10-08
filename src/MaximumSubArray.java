/*
* 53. Maximum Subarray
* Given an integer array nums, find the subarray with the largest sum, and return its sum.
*
* */
public class MaximumSubArray {

    public static void main(String args[]) {

        MaximumSubArray m = new MaximumSubArray();
        int[] arr = {-2, 3, 4, -1, -2, 5, -1, 8};

        int res = m.findMaxSum(arr);
        System.out.println("Maximum sum is: " + res);
    }

    public int findMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int element : arr) {
            sum = sum + element;
            if (sum > maxSum)
                maxSum = sum;
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
