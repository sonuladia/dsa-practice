package LeetCodeBlind75;

public class IncreasingTripletSubsequence {

    public static void main(String[] args){
        int[] nums = {2,1,5,0,4,6};
        System.out.println("Is there a triplet in this array? " + increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;

        int i=0, j=1, k=2;

        while(i<n && j<n && k<n){
            if(i<j && i<k && j<k){
                if(nums[i] < nums[j] && nums[j] < nums[k] && nums[i] < nums[k])
                    return true;
            }
            i++;
            j++;
            k++;
        }
        return false;
    }
}
