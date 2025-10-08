import java.util.Arrays;

/*
 * 2149. Rearrange Array Elements by Sign
 *
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive
 * and negative integers.
 * You should return the array of nums such that the the array follows the given conditions:
 * 1. Every consecutive pair of integers have opposite signs.
 * 2. For all integers with the same sign, the order in which they were present in nums is preserved.
 * 3. The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 * */
public class RearrangeElementsBySign {

    public static void main(String args[]) {

        int[] arr = {-2, 3, 4, -1, -2, 5, -1, 8};

        int[] res = rearrangeArray(arr);
        System.out.println("Rearranged array by sign : " + Arrays.toString(res));
    }

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                res[negIndex] = nums[i];
                negIndex = negIndex + 2;
            } else {
                res[posIndex] = nums[i];
                posIndex = posIndex + 2;
            }
        }
        return res;
    }
}
