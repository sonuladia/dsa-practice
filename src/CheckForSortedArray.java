/*
* Check whether array is sorted or not return true or false
* */
public class CheckForSortedArray {

    public static void main(String args[]){
        //int[] nums = {7,7,5,4,6,0,0,1,3};
        //int[] nums = {0,1,3,4,5,6,6,7,7};
        //int[] nums = {0,-1,-2,1,3,-7,7,5,-4,6};
        int[] nums = {-7,-7,-5,-2,-1,-1,0,1,1,3,8,9};
        boolean res = isArraySorted(nums);
        System.out.println("Is this array sorted: " + res);
    }

    private static boolean isArraySorted(int[] nums) {
        for(int i=1; i<nums.length; i++){
            if(nums[i] < nums[i-1])
                return false;
        }
        return true;
    }
}
