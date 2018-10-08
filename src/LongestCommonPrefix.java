public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] strs = {"abcd","abc","a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String ret = strs[0];
        for( int i = 0; i < ret.length(); i++){
            for( int j = 1; j < strs.length; j++){
                if(strs[j].length() - 1 < i || ret.charAt(i) != strs[j].charAt(i)){
                    ret = ret.substring(0, i);
                    break;
                }
            }
        }
        return ret;
    }
}
