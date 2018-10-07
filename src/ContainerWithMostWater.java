public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        while(i < j){
            ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return ans;
    }
}