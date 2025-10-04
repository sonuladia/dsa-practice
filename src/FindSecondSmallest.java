/*
 * Find second-smallest element in an array
 **/
public class FindSecondSmallest {

    public static void main(String args[]){
        //int[] nums = {7,7,5,4,6,0,0,1,3};
        //int[] nums = {0,1,3,7,7,5,4,6};
        //int[] nums = {0,-1,-2,1,3,-7,7,5,-4,6};
        int[] nums = {0,-1,-2,-1,-3,-7,-7,-5,-4,-6};
        int res = findSecondLargest(nums);
        System.out.println("Second Smallest Element is: " + res);
    }

    private static int findSecondLargest(int[] nums) {
        int smallest = nums[0], secondSmallest = Integer.MAX_VALUE;

        for(int i=1; i<nums.length; i++){

            if(nums[i] < smallest){
                secondSmallest = smallest;
                smallest = nums[i];
            } else if(nums[i] > smallest && nums[i] < secondSmallest)
                secondSmallest = nums[i];
        }
        return secondSmallest;
    }
}
