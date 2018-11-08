import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args){
        int[] nums = {1,2,2};
        List<List<Integer>> ret = new Solution().permuteUnique(nums);
        for( List i : ret){
            System.out.println(i.toString());
        }
    }
}

class Solution {
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return ret;
        dfs(nums, 0, nums.length);
        return ret;
    }


    void dfs(int[] nums, int start, int end){
        if(start == end - 1){
            List<Integer> list = new ArrayList<>();
            for( int i = 0; i < end; i++){
                list.add(nums[i]);
            }
            ret.add(list);
            return;
        }
        for( int i = start; i < end; i++){
            boolean found = false;
            for( int j = start; j < i; j++){
                if(nums[i] == nums[j]) {
                    found = true;
                    break;
                }
            }
            if(found) continue;
            swap(nums, start, i);
            dfs(nums, start + 1, end);
            swap(nums, start, i);
        }
    }

    void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}