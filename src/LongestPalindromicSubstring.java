public class LongestPalindromicSubstring {
    public static void main(String[] args){
        String s = "";
        System.out.println(new Solution().longestPalindrome(s));
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int startIdx = 0, maxStrlen = 1;
        boolean[][] p = new boolean[len][len];
        for( int i = 0; i < len; i++){
            p[i][i] = true;
            int j = i + 1;
            if(j < len && s.charAt(i) == s.charAt(j)) {
                startIdx = i;
                maxStrlen = 2;
                p[i][j] = true;
            }
        }
        for( int strlen = 3; strlen <= len; strlen++){
            for( int i = 0; i <= len - strlen; i++){
                int j = i + strlen - 1;
                if(s.charAt(i) == s.charAt(j) && p[i+1][j-1] == true) {
                    p[i][j] = true;
                    startIdx = i;
                    if(strlen > maxStrlen) maxStrlen = strlen;

                }
                else p[i][j] = false;
            }
        }
        if(s.length() == 0) return "";
        return s.substring(startIdx, startIdx + maxStrlen);
    }
}