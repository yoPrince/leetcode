import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args){
        int[] nums = {1,1,2,2,0,0,0,-1,5,-3};
        System.out.println(new Solution().threeSum(nums));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(len < 3) return result;
        Arrays.sort(nums);
        for( int k = 0; k < len; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = len -1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum == 0){
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i < j && nums[i] == nums[i + 1]) i++;
                    while(i < j && nums[j] == nums[j - 1]) j--;
                    i++; j--;
                } else if(sum < 0) i++;
                else j--;
            }
        }
        return result;
    }
}