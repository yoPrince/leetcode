public class ImplementstrStr {
    public static void main(String[] args){
        System.out.println(new Solution().strStr("abba","bba"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int[] next = getNext(needle);
        int i = 0, j = 0;
        int len1 = haystack.length(), len2 = needle.length();
        while(i < len1 && j < len2){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else j = next[j];
        }
        if(j >= len2) return i - j;
        return -1;
    }

    int[] getNext(String needle){
        int len = needle.length();
        int[] next = new int[len];
        next[0] = -1;
        int k = -1, i = 0;
        while(i < len - 1){
            if(k == -1 || needle.charAt(i) == needle.charAt(k)){
                if(needle.charAt(++i) == needle.charAt(++k)){
                    next[i] = next[k];
                } else next[i] = k;
            } else k = next[k];
        }
        return next;
    }
}