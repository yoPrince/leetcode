public class AddBinary {
    public static void main(String[] args){
        System.out.println(new Solution().addBinary("10","111110"));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        int la = a.length(), lb = b.length();
        char[] ret = new char[Math.max(la, lb) + 1];
        int i = la - 1, j = lb - 1, k = 0, c = 0;
        while(i >= 0 && j >= 0){
            c = a.charAt(i--) - '0' + b.charAt(j--) - '0' + c;
            ret[k++] = (char) ('0' + c  % 2);
            c /= 2;
        }
        while(i >= 0){
            c = a.charAt(i--) - '0' + c;
            ret[k++] = (char) ('0' + c % 2);
            c /= 2;
        }
        while(j >= 0){
            c = b.charAt(j--) - '0' + c;
            ret[k++] = (char) ('0' + c % 2);
            c /= 2;
        }
        if(c > 0) ret[k++] = (char) ('0' + c);
        StringBuffer str = new StringBuffer();
        while(k > 0){
            str.append(ret[--k]);
        }
        return str.toString();
    }
}

