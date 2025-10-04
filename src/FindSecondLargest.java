/*
* Find second-largest element in an array
**/
public class FindSecondLargest {

    public static void main(String args[]){
        //int[] nums = {0,1,3,7,7,5,4,6};
        //int[] nums = {0,-1,-2,1,3,-7,7,5,-4,6};
        int[] nums = {0,-1,-2,-1,-3,-7,-7,-5,-4,-6};
        int res = findSecondLargest(nums);
        System.out.println("Second Largest Element is: " + res);
    }

    private static int findSecondLargest(int[] nums) {
        int largest = nums[0], slargest = Integer.MIN_VALUE;

        for(int i = 1; i<nums.length; i++){

            if(nums[i] > largest){
                slargest = largest;
                largest = nums[i];
            }
            else if (nums[i] < largest && nums[i] > slargest)
                slargest = nums[i];
        }

        return slargest;
    }
}
