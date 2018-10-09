import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args){
        System.out.println(new Solution().isValid("()[]{"));
        System.out.println(new Solution().isValid("([)]"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for( int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else if(stack.empty()) return false;
            else {
                char top = stack.pop();
                if(ch == ')' && top != '(') return false;
                if(ch == '}' && top != '{') return false;
                if(ch == ']' && top != '[') return false;
            }
        }
        return stack.empty();
    }
}