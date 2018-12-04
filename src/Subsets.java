import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> ret = new Solution().subsets(nums);
        for(List i : ret){
            System.out.println(i.toString());
        }
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        ret.add(new ArrayList<>());
        if(nums.length == 0) return new ArrayList<>(ret);
        for( int i = 0; i < nums.length; i++){
            int len = ret.size();
            for( int j = 0; j < len; j++){
                List<Integer> tmp = new ArrayList<>(ret.get(j));
                tmp.add(nums[i]);
                ret.add(tmp);
            }
        }
        return new ArrayList<>(ret);
    }
}