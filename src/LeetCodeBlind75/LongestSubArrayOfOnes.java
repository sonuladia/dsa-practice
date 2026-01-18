package LeetCodeBlind75;

public class LongestSubArrayOfOnes {
    public static void main(String[] args){
        int[] nums = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println("Longest sub-array of 1's after deleting one element: " + longestSubarray(nums));
    }

    public static int longestSubarray(int[] nums) {
        int left = 0, right =0;
        int zeros =0, maxLength =0;

        while(right<nums.length){
            if(nums[right] == 0)
                zeros++;
            while(zeros > 1){
                if(nums[left] == 0)
                    zeros--;
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }

        return maxLength -1;
    }
}
