public class DivideTwoIntegers {
    public static void main(String[] args){
        System.out.println(new Solution().divide(Integer.MIN_VALUE,1));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long dvd = Math.abs((long)dividend);
        long dvr = Math.abs((long)divisor);
        long ret = 0, cnt = 1;
        while(dvd >= dvr){
            cnt <<= 1;
            dvr <<= 1;
        }
        while(dvr > 0){
            if(dvd >= dvr){
                dvd -= dvr;
                ret += cnt;
            }
            cnt >>= 1;
            dvr >>= 1;
        }
        return ((dividend < 0) ^ (divisor < 0)) ? (int)-ret : (int)ret;
    }
}