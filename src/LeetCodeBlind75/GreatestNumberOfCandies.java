package LeetCodeBlind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreatestNumberOfCandies {
    public static void main(String[] args){
        int[] candies = {2,3,4,5,1,3};
        int extraCandies = 3;
        System.out.println("final boolean array: "+ kidsWithCandies(candies, extraCandies));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = Arrays.stream(candies).max().getAsInt();
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= greatest)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }
}
