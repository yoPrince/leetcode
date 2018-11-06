import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> ret = new Solution().permute(nums);
        for( List i : ret){
            System.out.println(i.toString());
        }
    }
}

class Solution {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0 || nums == null) return ret;
        dfs(nums, 0, nums.length - 1);
        return ret;
    }

    void dfs(int[] nums, int start, int end){
        if(start == end){
            List<Integer> list = new ArrayList<>();
            for( int i = 0; i <= end; i++){
                list.add(nums[i]);
            }
            ret.add(list);
            return;
        }
        for( int i = start; i <= end; i++){
            swap(nums, start, i);
            dfs(nums, start + 1, end);
            swap(nums, start, i);
        }
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
