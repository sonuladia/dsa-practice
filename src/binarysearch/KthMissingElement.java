package binarysearch;

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Return the kth positive integer that is missing from this array.
 */

public class KthMissingElement {

    public static void main(String[] args) {
        KthMissingElement obj = new KthMissingElement();

        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        System.out.println("Result 1: " + obj.findKthPositive(arr1, k1)); // Expected 9

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 2;
        System.out.println("Result 2: " + obj.findKthPositive(arr2, k2)); // Expected 6

        int[] arr3 = {5, 6, 7, 8};
        int k3 = 3;
        System.out.println("Result 3: " + obj.findKthPositive(arr3, k3)); // Expected 3
    }

    public int findKthPositive(int[] arr, int k) {
        int low =0, high = arr.length-1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid+1);
            if (missing < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high + 1 + k;
    }
}
