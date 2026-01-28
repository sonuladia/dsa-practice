package leetcodeblind75;

import java.util.Arrays;
import java.util.List;

public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        char[] chArray = s.toCharArray();
        int left = 0, right = chArray.length-1;
        List<Character> vowels = List.of('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U');

        while (left < right){
            if(!vowels.contains(chArray[left]))
                left = left+1;
            else if(!vowels.contains(chArray[right]))
                right = right-1;
            else {
                char temp = chArray[left];
                chArray[left] = chArray[right];
                chArray[right] = temp;
                left++;
                right--;
            }
        }
        return Arrays.toString(chArray);
    }
}
