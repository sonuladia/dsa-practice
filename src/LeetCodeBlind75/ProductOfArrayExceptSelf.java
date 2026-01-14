package LeetCodeBlind75;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int prefix = 1, postfix = 1, n = nums.length;
        int[] res = new int[nums.length];

        for(int i =0; i<n; i++){
            res[i] = prefix;
            prefix = prefix * nums[i];
        }
        for(int i = n-1; i >= 0; i--){
            res[i] = res[i] * postfix;
            postfix = postfix * nums[i];
        }
        return res;
    }
}
