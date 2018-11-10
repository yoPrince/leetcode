public class JumpGame {
    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        System.out.println(new Solution().canJump(nums));
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0, len = nums.length;
        for( int i = 0; i < len; i++){
            if(i > reach) return false;
            reach = Math.max(reach, i + nums[i]);
        }
        return true;
    }
}