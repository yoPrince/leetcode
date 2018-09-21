import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        String str = "aaapwkekka";
        System.out.println(new Solution().lengthOfLongestSubstring(str));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int ans =0;
        int L = -1, R = -1;
        while(R + 1 < s.length()){
            R++;
            if(map.containsKey(s.charAt(R))){
                L = map.get(s.charAt(R)) > L ? map.get(s.charAt(R)) : L;
            }
            map.put(s.charAt(R), R);
            ans = Math.max(R-L, ans);
        }
        ans = Math.max(R-L, ans);
        return ans;
    }
}
