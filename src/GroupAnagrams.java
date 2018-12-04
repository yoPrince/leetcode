import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = new Solution().groupAnagrams(strs);
        for(List i : ret){
            System.out.println(i.toString());
        }
    }
}


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ret = new HashMap<>();
        for (String i : strs) {
            char[] tmp = i.toCharArray();
            Arrays.sort(tmp);
            String itmp = new String(tmp);
            if (!ret.containsKey(itmp)) {
                ret.put(itmp, new ArrayList<>());
            }
            ret.get(itmp).add(i);
        }
        return new ArrayList<>(ret.values());
    }
}