public class SearchInsertPosition {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        System.out.println(new Solution().searchInsert(nums, 0));
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) >> 1;
            if(target <= nums[m]) r = m - 1;
            else l = m + 1;
        }
        return l;
    }
}