/*
 * 31. Next Permutation
 *
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * */

import java.util.Arrays;

public class NextPermutation {

    public static void main(String args[]) {
        int[] nums = {2, 1, 5, 4, 3, 0, 0};
        nextPermutation(nums);
        System.out.println("Rearranged array by sign : " + Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        if (ind == (-1)) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i >= ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        reverse(nums, ind + 1, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
