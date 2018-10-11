public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args){
        int[] nums = {0,1,1,2,2,3,5};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 0, pre = 0;
        int len = nums.length;
        if(len == 0) return pre;
        for( int i = 1; i < len; i++){
            if(nums[i] == nums[pre]) {
                cnt++;
            } else if(cnt == 0 && i == pre + 1) {
                pre++;
            } else {
                pre++;
                swap(nums, i, pre);
                if(cnt > 0) cnt--;
            }
        }
        return pre + 1;
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}