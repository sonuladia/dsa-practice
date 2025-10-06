/*
 * 485. Max Consecutive Ones
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * */
public class MaxConsecutiveOnes {

    public static void main(String args[]) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int res = findMaxConsecutiveOnes(nums);
        System.out.println("Maximum number of consecutive ones : " + res);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count = 0;
            else {
                count++;
                if (max < count)
                    max = count;
            }
        }
        return max;
    }

}
