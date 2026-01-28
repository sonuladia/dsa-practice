package leetcodeblind75;

public class MaxConsecutiveOnes {
    public static void main(String[] args){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println("Maximum consecutive ones after removing k zeros: " + longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int maxLength =0;
        int zeros =0;
        int l=0, r=0;

        while(r < nums.length){
            if(nums[r] == 0)
                zeros++;
            if(zeros <= k){
                int len = r-l+1;
                maxLength = Math.max(maxLength, len);
            }
            if(zeros > k){
                if(nums[l] == 0)
                    zeros--;
                l++;
            }
            r++;
        }

        return maxLength;
    }
}
