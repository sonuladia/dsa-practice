package leetcodeblind75;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args){
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println("The minimum number of intervals you need to " +
                "remove to make the rest of the intervals non-overlapping: " + eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int prevEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= prevEnd){
                count++;
                prevEnd = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
