public class StringtoInteger {
    public static void main(String[] args){
        System.out.println(new Solution().myAtoi("  "));
        System.out.println(new Solution().myAtoi("0"));
        System.out.println(new Solution().myAtoi(""));
        System.out.println(new Solution().myAtoi("   -15"));
        System.out.println(new Solution().myAtoi("4193 with words"));
        System.out.println(new Solution().myAtoi("words and 987"));
        System.out.println(new Solution().myAtoi("-91283472332"));
    }
}

class Solution {
    public int myAtoi(String str) {
        int i = 0, len = str.length(), ans = 0;
        boolean isPositive = true;
        if(str == null) return 0;
        while(i < len && str.charAt(i) == ' ') i++;
        if(i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            isPositive = str.charAt(i) == '+';
            i++;
        }
        else if(i < len && (str.charAt(i) < '0' || str.charAt(i) > '9')) return 0;

        for( ; i < len; i++){
            int tmp = str.charAt(i) - '0';
            if(tmp < 0 || tmp > 9) break;
            tmp = ans * 10 + tmp;
            if(tmp / 10 != ans) return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ans = tmp;
        }
        if(isPositive) return ans;
        else return -ans;
    }
}