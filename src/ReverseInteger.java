public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
        System.out.println(new Solution().reverse(-1000));
        System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(321));
    }
}

class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int t = x % 10 + ans * 10;
            if(t / 10 != ans) return 0;
            ans = t;
            x /= 10;
        }
        return ans;
    }
}
