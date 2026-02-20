package binarysearch;

import java.util.Arrays;

public class MinNoOfDaysToMakeMBouquets {

    public static void main(String[] args){
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        int res = minDays(bloomDay, m, k);
        System.out.println("final result: " + res);
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long)m*k) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();

        while(low <= high){
            int mid = low + (high - low) / 2;
            boolean possibleBloomDay = isPossibleBloomDay(bloomDay, mid, m, k);
            if(possibleBloomDay)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }

    public static boolean isPossibleBloomDay(int[] bloomDay, int day, int m, int k){
        int count = 0;
        int noOfBouquets = 0;
        for (int j : bloomDay) {
            if (j <= day)
                count++;
            else {
                noOfBouquets += count/k;
                count = 0;
            }
        }
        noOfBouquets += count/k ;
        return noOfBouquets >= m;
    }
}
