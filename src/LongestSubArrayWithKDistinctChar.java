import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithKDistinctChar {

    public static void main(String[] args){
        String s = "aababbcaacc";
        int k = 2;
        System.out.println("Longest SubArray with K distinct char: " + kDistinctChar(s,k));

    }

    public static int kDistinctChar(String s, int k) {
        //your code goes here
        int maxLength =0, l=0, r=0;
        Map<Character, Integer> mpp = new HashMap<>();

        while(r < s.length()){
            mpp.put(s.charAt(r), mpp.getOrDefault(s.charAt(r), 1)+1);
            if(mpp.size() > k){
                int hash = mpp.get(s.charAt(l));
                mpp.put(s.charAt(l), hash-1);
                if (hash == 0)
                {
                    mpp.remove(s.charAt(l));
                    l++;
                }
            }
            if(mpp.size() <= k){
                maxLength = Math.max(maxLength, r-l+1);
            }
            r++;
        }
        return maxLength;
    }
}
