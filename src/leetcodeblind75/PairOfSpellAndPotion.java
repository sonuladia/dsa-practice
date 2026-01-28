package leetcodeblind75;

import java.util.Arrays;

public class PairOfSpellAndPotion {

    public static void main(String[] args){
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        long success = 7;

        int[] result = successfulPairs(spells, potions, success);
        System.out.println("the number of potions that will form a successful pair: "+ Arrays.toString(result));
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long spell = spells[i];
            // minimal potion strength needed
            long needed = (success + spell - 1) / spell; // ceiling(success / spell)

            int idx = binarySearch(potions, needed);
            result[i] = (idx == -1) ? 0 : (m - idx);
        }
        return result;
    }

    private static int binarySearch(int[] potions, long target) {
        int left = 0, right = potions.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
