import java.util.Stack;

public class LargestRectangleinHistogram {
    public static void main(String[] args){
        int[] heights = {4,2,0,3,2,5};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int i = 0, len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        while(i <= len){
            int height = i == len ? 0 : heights[i];
            if(stack.isEmpty() || height >= heights[stack.peek()]){
                stack.push(i++);
            } else {
                int tempHeight = heights[stack.pop()];
                maxArea = Math.max(maxArea, tempHeight * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }
        return maxArea;
    }
}