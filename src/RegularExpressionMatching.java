public class RegularExpressionMatching {
    public static void main(String[] args){
        System.out.println(new Solution().isMatch("aa","a"));
        System.out.println(new Solution().isMatch("aa","a*"));
        System.out.println(new Solution().isMatch("ab",".*"));
        System.out.println(new Solution().isMatch("aab","c*a*b"));
        System.out.println(new Solution().isMatch("mississippi","mis*is*p*."));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for( int i = 1; i <= n; i++) dp[i][0] = false;
        for( int j = 1; j <= m; j++) dp[0][j] = j > 1 && dp[0][j - 2] && p.charAt(j - 1) == '*';
        for( int i = 1; i <= n; i++) {
            for( int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') dp[i][j] = dp[i][j - 2]
                        || dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.');
                else dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.');
            }
        }
        return dp[n][m];
    }
}
