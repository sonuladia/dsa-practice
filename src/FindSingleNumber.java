/*
 * 136. Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 * */
public class FindSingleNumber {

    public static void main(String args[]) {
        int[] nums = {1, -3, 0, 0, 4, -3, 1, 2, 2};
        int res = singleNumber(nums);
        System.out.println("Number occurring only once in an array : " + res);
    }

    private static int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
