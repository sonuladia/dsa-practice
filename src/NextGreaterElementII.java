import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args){
        int[] nums = {31, 33, 37 ,11, 59, 100, 35};
        int[] res = nextGreaterElements(nums);
        System.out.println("final result: " + Arrays.toString(res));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();

        for(int i = 2*n-1; i>=0; i--){
            int ind = i%n;
            while(!st.isEmpty() && st.peek() <= nums[ind])
                st.pop();
            if(i < n){
                if(!st.isEmpty())
                    res[ind] = st.peek();
            }
            st.push(nums[ind]);
        }
        return res;
    }
}
