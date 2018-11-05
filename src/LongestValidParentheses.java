import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args){
        System.out.println(new Solution().longestValidParentheses(")(((((()())()()))()(()))("));
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, len = s.length(), maxLen = 0, start = 0;
        while(i < len){
            char tmp = s.charAt(i);
            if(tmp == '(') stack.push(i);
            else {
                if(stack.isEmpty()){
                    start = i + 1;
                } else {
                    stack.pop();
                    maxLen = Math.max(maxLen, stack.isEmpty() ? i - start + 1 : i - stack.peek());
                }
            }
            i++;
        }
        return maxLen;
    }
}