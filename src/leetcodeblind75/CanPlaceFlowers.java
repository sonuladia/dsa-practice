package leetcodeblind75;

public class CanPlaceFlowers {
    public static void main(String[] args){
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println("Can place flower in this flower bed? " + canPlaceFlowers(flowerbed, n));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i=0; i<len; i++) {
            boolean left = (i ==0) || flowerbed[i-1] == 0;
            boolean right = (i == len-1) || flowerbed[i+1] == 0;
            if(left && right && flowerbed[i] == 0){
                flowerbed[i] = 1;
                n = n-1;
                if(n == 0)
                    return true;
            }
        }
        return false;
    }
}
