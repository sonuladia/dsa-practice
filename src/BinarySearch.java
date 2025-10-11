public class BinarySearch {

    public static void main(String[] args){
        int[] nums = {0,2,4,5,8,10,13,14,16};
        int target = 9;
        boolean found = binarySearch(nums, target);
        System.out.println("Is target present : "+found);
    }

    private static boolean binarySearch(int[] nums, int target) {
        if(nums.length == 0)
            return false;
        int low = 0;
        int high = nums.length-1;
        return bs(nums, low, high, target);

    }

    private static boolean bs(int[] nums, int low, int high, int target) {
        if(low > high)
            return false;
        int mid = (low + high)/2;
            if (nums[mid] == target)
                return true;
            else if (target > nums[mid])
                return bs(nums, mid + 1, high, target);
            else
                return bs(nums, low, mid-1, target);

    }

}
