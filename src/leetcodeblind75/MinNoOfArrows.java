package leetcodeblind75;

import java.util.Arrays;
import java.util.Comparator;

public class MinNoOfArrows {

    public static void main(String[] args){
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println("The minimum number of arrows " +
                "that must be shot to burst all balloons: " + findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrows = 1;
        int prevEnd = points[0][1];
        for(int i=1; i<points.length; i++){
            if(points[i][0] > prevEnd){
                arrows++;
                prevEnd = points[i][1];
            }
        }
        return arrows;
    }
}
