package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreviousSmallerElement {

    public static void main(String[] args){
        int[] nums = {1, 5, 0, 3, 4, 5};
        int[] res = nextSmallerElements(nums);
        System.out.println("final result: " + Arrays.toString(res));
    }

    public static int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() > nums[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return res;
    }
}
