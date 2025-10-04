/*
* Remove duplicates from sorted array
*/
public class RemoveDuplicates {

    public static void main(String args[]){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        printArray(nums, res);
    }

    public static void printArray(int[] nums, int res) {
        System.out.print("[");
        for (int i = 0; i < res; i++) {
            System.out.print(nums[i]);
            if (i < res - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
