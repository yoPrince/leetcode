public class MaximumSubarray {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int maxSum = nums[0], tmp = nums[0];
        for( int i = 1; i < nums.length; i++){
            if(tmp < 0) tmp = 0;
            tmp += nums[i];
            maxSum = Math.max(maxSum, tmp);
        }
        return maxSum;
    }
}
