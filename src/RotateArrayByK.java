import java.util.Arrays;

/*
 * 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * */
public class RotateArrayByK {

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        int[] res1 = leftRotateByK(nums1, k1);
        System.out.println("Array after left rotating by k where k=" + k1 + " : " + Arrays.toString(res1));

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        int[] res2 = rightRotateByK(nums2, k2);
        System.out.println("Array after left rotating by k where k=" + k2 + " : " + Arrays.toString(res2));
    }

    private static int[] leftRotateByK(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, nums.length - 1);
        return nums;
    }

    private static int[] rightRotateByK(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, 0, n - 1);
        return nums;
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
}
