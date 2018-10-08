import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args){
        System.out.println(new Solution().letterCombinations("24"));
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) return result;
        backtracking("", 0, digits, result);
        return result;
    }

    void backtracking(String prefix, int cnt, String digits, List<String> result){
        String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(cnt == digits.length()) {
            result.add(prefix);
            return;
        }
        int digit = digits.charAt(cnt) - '2';
        for( int i = 0; i < strs[digit].length(); i++){
            backtracking(prefix + strs[digit].charAt(i), cnt + 1, digits, result);
        }
    }
}