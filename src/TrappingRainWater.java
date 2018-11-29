public class TrappingRainWater {
    public static void main(String[] args){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(height));
    }
}


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) return 0;
        int maxSum = 0, maxRight = 0;
        int[] maxR = new int[height.length];
        for( int i = height.length - 1; i >= 0; i--){
            if(height[i] > maxRight)  maxR[i] = maxRight = height[i];
            else maxR[i] = maxRight;
        }
        int maxLeft = height[0];
        for( int i = 1; i < height.length; i++){
            maxSum += Math.max(Math.min(maxLeft, maxR[i]) - height[i], 0);
            if(height[i] > maxLeft) maxLeft = height[i];
        }
        return maxSum;
    }
}