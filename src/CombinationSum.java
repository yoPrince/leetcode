import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ret = new Solution().combinationSum(candidates, target);
        for( List i : ret){
            System.out.println(i.toString());
        }
    }
}

class Solution {
    private List<List<Integer>> ret;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, list, 0);
        return ret;
    }

    private void dfs(int[] candidates, int target, List<Integer> list, int pos){
        if(target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for( int i = pos; i < candidates.length; i++){
            if(candidates[i] <= target){
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}