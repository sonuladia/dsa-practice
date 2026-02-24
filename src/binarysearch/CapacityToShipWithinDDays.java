package binarysearch;

import java.util.Arrays;

public class CapacityToShipWithinDDays {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int res = shipWithinDays(nums, days);
        System.out.println("final result: " + res);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low <= high){
            int mid = low + (high - low) / 2;
            boolean result = isPossibleShipDay(weights, mid, days);
            if(result)
                high = mid - 1;
            else
               low = mid + 1;
        }
        return low;
    }

    public static boolean isPossibleShipDay(int[] weights, int capacity, int days){
        int currentWeight = 0;
        int dayCount = 1;
        for(int weight : weights){
            if(currentWeight + weight > capacity){
                dayCount++;
                currentWeight = weight;
            } else {
                currentWeight += weight;
            }
        }
        return dayCount <= days;
    }
}
