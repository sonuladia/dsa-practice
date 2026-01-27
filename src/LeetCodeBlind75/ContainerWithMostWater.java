package LeetCodeBlind75;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();

        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result1 = solver.maxArea(height1);
        System.out.println("Max area (test 1): " + result1);  // Expected: 49

        int[] height2 = {1, 1};
        int result2 = solver.maxArea(height2);
        System.out.println("Max area (test 2): " + result2);  // Expected: 1

        int[] height3 = {4, 3, 2, 1, 4};
        int result3 = solver.maxArea(height3);
        System.out.println("Max area (test 3): " + result3);  // Expected: 16

        int[] height4 = {1, 2, 1};
        int result4 = solver.maxArea(height4);
        System.out.println("Max area (test 4): " + result4);  // Expected: 2
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxArea = 0;

        while(l < r ){
            int area = (r-l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);

            if(height[l] < height[r])
                l++;
            else r--;
        }
        return maxArea;
    }
}
