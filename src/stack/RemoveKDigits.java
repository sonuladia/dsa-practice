package stack;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args){
        String nums = "100001";
        int k = 1;
        String res = removeKDigits(nums, k);
        System.out.println("final result: " + res);
    }

    public static String removeKDigits(String num, int k) {
        int n = num.length();
        if(k == n) return "0";

        Stack<Character> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        res.reverse();

        while(res.length() > 1 && res.charAt(0) == '0'){
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}
