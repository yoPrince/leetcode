import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args){
        int[] nums = {3, 4, 1, 7};
        int target = 8;
        int[] ans = new Solution().twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for( int i = 0; i < len; i++){
            for( int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}