/*
 * 169. Majority Element
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * */
public class MajorityElement {

    public static void main(String args[]) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int res = majorityElement(nums);
        System.out.println("Majority Element is : " + res);
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (nums[i] == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}
