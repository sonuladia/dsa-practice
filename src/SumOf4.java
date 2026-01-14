import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf4 {
    public static void main(String args[]) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> output = fourSum(nums, target);

        System.out.println(formatListOfList(output));
    }

    public static String formatListOfList(List<List<Integer>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toString());
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long target_2 = (long) target - nums[i] - nums[j];
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[left] + nums[right];
                    if (sum < target_2) left++;
                    else if (sum > target_2) right--;
                    else {
                        List<Integer> quads = new ArrayList<Integer>();
                        quads.add(nums[i]);
                        quads.add(nums[j]);
                        quads.add(nums[left]);
                        quads.add(nums[right]);
                        res.add(quads);

                        //to not have duplicate entries
                        while (left < right && nums[left] == quads.get(2)) left++;
                        while (left < right && nums[right] == quads.get(3)) right--;
                    }

                }

                //we want no duplicates with j
                while (j + 1 < n && nums[j + 1] == nums[j]) j++;
            }
            //we want no duplicates with i
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }
}
