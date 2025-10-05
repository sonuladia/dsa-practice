/*
 * 268. Missing Number - Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * */
public class MissingElement {

    public static void main(String args[]) {
        int[] nums = {3, 0, 1};
        int res = missingNumber(nums);
        System.out.println("Missing number from array is : " + res);
    }

    private static int missingNumber(int[] nums) {
        int n = nums.length;
        int arraySummation = (n * (n + 1)) / 2;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
        }
        return arraySummation - sum;
    }
}
