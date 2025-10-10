import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaderInArray {

    public static void main(String args[]) {
        int[] nums = {10, 22, 12, 3, 4, 0, 6};
        int[] res = superiorElements(nums);
        System.out.println("Leaders in an array : " + Arrays.toString(res));
    }

    private static int[] superiorElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > max) {
                list.add(nums[i]);
                max = nums[i];
            }
            max = Math.max(max, nums[i]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
