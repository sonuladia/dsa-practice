import java.util.HashSet;
import java.util.Set;

/*
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * */
public class LongestConsecutiveSequence {

    public static void main(String args[]) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int res = longestConsecutive(nums);
        System.out.println("longest consecutive sequence : " + res);
    }

    private static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int longest = 1;
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        for (int element : st) {
            if (!st.contains(element - 1)) {
                int current = element;
                int count = 1;
                while (st.contains(current + 1)) {
                    current = current + 1;
                    count = count + 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
