public class RemoveElement {
    public static void main(String[] args){
        int[] nums = {0,0,1,2,2,2};
        System.out.println(new Solution().removeElement(nums,2));
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int pre = 0, len = nums.length;
        if(len == 0) return pre;
        for( int i = 0; i < len; i++){
            if(nums[i] != val){
                if(pre != i) swap(nums, i, pre);
                pre++;
            }
        }
        return pre;
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}