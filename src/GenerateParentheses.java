import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args){
        List<String> list = new Solution().generateParenthesis(3);
        System.out.println(list);
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtracking("", n, 0, 0, list);
        return list;
    }

    void backtracking(String prefix, int n, int l, int r, List<String> list){
        if(l == n && r == n) {
            list.add(prefix);
            return;
        }
        if(l <= r && l < n){
            backtracking(prefix + "(", n, l + 1, r, list);
        } else {
            if(l < n) backtracking(prefix + "(", n, l + 1, r, list);
            if(r < n) backtracking(prefix + ")", n, l, r + 1, list);
        }
    }
}