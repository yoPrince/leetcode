import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args){
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if(matrix.length == 0) return maxArea;
        int n = matrix.length, m = matrix[0].length;
        int[] height = new int[m];
        for( int i = 0; i < n; i++){
            for( int j = 0; j < m; j++) height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            int j = 0;
            Stack<Integer> stack = new Stack<>();
            while(j <= m){
                int tmp = j == m ? 0 : height[j];
                if(stack.isEmpty() || tmp >= height[stack.peek()]) stack.push(j++);
                else {
                    int idx = stack.pop();
                    maxArea = Math.max(maxArea, height[idx] * (stack.isEmpty() ? j : j - 1 - stack.peek()));
                }
            }
        }
        return maxArea;
    }
}

