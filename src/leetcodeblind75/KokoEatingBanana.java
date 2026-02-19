package leetcodeblind75;

import java.util.Arrays;

public class KokoEatingBanana {

    public static void main(String[] args){
        int[] piles = {3,6,7,11};
        int h = 8;
        int res = minEatingSpeed(piles, h);
        System.out.println("final result: " + res);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while(low <= high){
            int mid = (low+high)/2;
            int totalHourTaken = findTotalHoursTaken(piles, mid);
            if(totalHourTaken <= h)
                high = mid-1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int findTotalHoursTaken(int[] piles, int hours){
        int total = 0;
        for (int pile : piles) {
            total += Math.ceil((double) pile / (double) hours);
        }
        return total;
    }
}
