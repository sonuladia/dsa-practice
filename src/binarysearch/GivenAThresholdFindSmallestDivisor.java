package binarysearch;

import java.util.Arrays;

public class GivenAThresholdFindSmallestDivisor {

    public static void main(String[] args){
        int[] nums = {1,2,5,9};
        int threshold = 6;
        int res = smallestDivisor(nums, threshold);
        System.out.println("final result: " + res);
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        while(low <= high){
            int mid = low + (high - low) / 2;
            int result = divideAndSum(nums, mid);
            if(result <= threshold)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int divideAndSum(int[] nums, int divisor) {
        int sum = 0;
        for (int number : nums) {
            sum += (number + divisor - 1) / divisor;
        }
        return sum;
    }
}
