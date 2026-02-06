import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagramsInString {
    //Given two strings s and p, return an array of all the start indices of p's anagrams in s.
    // You may return the answer in any order.
   // Input: s = "cbaebabacd", p = "abc" Output: [0,6]

    public static void main(String[] args){
        String p = "abc";
        String s = "cbaebabacd";
        List<Integer> res = findAnagrams( s,  p);
        System.out.println("Output: " + res);
    }

    public static List<Integer> findAnagrams(String s, String p){
        Map<Character, Integer> freqMapP = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        for(Character c: p.toCharArray()){
            freqMapP.put(c, freqMapP.getOrDefault(c,0) +1);
        }

        for(int i=0; i<n; i++){
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(freqMapP.equals(window))
            res.add(0);

        for(int i=n; i<m; i++){
            char addChar = s.charAt(i);
            char removeChar = s.charAt(i-n);

            if(window.get(removeChar) == 1)
                window.remove(removeChar);
            else
                window.put(removeChar, window.get(removeChar) -1);

            window.put(addChar, window.getOrDefault(addChar,0)+1);

            if(freqMapP.equals(window))
                res.add(i-n+1);
        }
        return res;
    }
}
