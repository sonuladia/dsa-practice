import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 349. Intersection of Two Arrays
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique, and you may return the result in any order.
 * */
public class IntersectionOfArrays {

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersection(nums1, nums2);
        System.out.println("Intersection of two array with unique elements :" + Arrays.toString(res));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        List<Integer> res = new ArrayList<>();

        while (i < n && j < m) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums2[j] < nums1[i])
                j++;
            else if (nums1[i] == nums2[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != nums1[i])
                    res.add(nums1[i]);
                i++;
                j++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
