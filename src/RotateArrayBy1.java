import java.util.Arrays;

/*
 *  Rotate an array by one place on left and right
 * */
public class RotateArrayBy1 {

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] res1 = leftRotate(nums1);
        System.out.println("Array after left rotating by one: " + Arrays.toString(res1));

        int[] nums2 = {1, 2, 3, 4, 5};
        int[] res2 = rightRotate(nums2);
        System.out.println("Array after right rotating by one: " + Arrays.toString(res2));
    }

    private static int[] leftRotate(int[] nums) {
        int n = nums.length;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[n - 1] = temp;
        return nums;
    }

    private static int[] rightRotate(int[] nums) {
        int n = nums.length;
        int temp = nums[n - 1];
        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
        return nums;
    }
}
