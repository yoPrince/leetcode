import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new Solution().wordBreak("leetcode", wordDict));
    }
}


class Solution {
   public boolean wordBreak(String s, List<String> wordDict) {
       int len = s.length();
       HashSet set = new HashSet();
       for( String i : wordDict) set.add(i);
       boolean[] can = new boolean[len + 1];
       can[0] = true;
       for( int i = 0; i < len; i++){
           if(!can[i]) continue;
           for( int j = i + 1; j <= len; j++){
               if(set.contains(s.substring(i, j))) can[j] = true;
           }
       }
       return can[len];
   }
}