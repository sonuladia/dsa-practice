package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public static void main(String[] args){
        int[] nums = {4, 8, 5, 2, 25};
        int[] res = nextSmallerElements(nums);
        System.out.println("final result: " + Arrays.toString(res));
    }

    public static int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() > nums[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }
        return res;
    }
}
