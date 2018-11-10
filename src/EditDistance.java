public class EditDistance {
    public static void main(String[] args){
        System.out.println(new Solution().minDistance("horse","ros"));
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int w1 = word1.length(), w2 = word2.length();
        int[][] dp = new int[w1 + 1][w2 + 1];
        for( int i = 0; i <= w1; i++) dp[i][0] = i;
        for( int i = 0; i <= w2; i++) dp[0][i] = i;
        for( int i = 0; i < w1; i++){
            for( int j = 0; j < w2; j++){
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + replace(word1, word2, i, j));

            }
        }
        return dp[w1][w2];
    }

    int replace(String w1, String w2, int x, int y){
        if(w1.charAt(x) == w2.charAt(y)) return 0;
        return 1;
    }

}