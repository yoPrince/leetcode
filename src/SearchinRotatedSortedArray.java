public class SearchinRotatedSortedArray {
    public static void main(String[] args){
        int[] nums = {3};
        System.out.println(new Solution().search(nums, 1));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return -1;
        int minIdx = 0;
        for(int i = 1; i < len; i++){
            if(nums[i] < nums[i - 1]){
                minIdx = i;
                break;
            }
        }
        int l = minIdx, r = minIdx + len - 1;
        while(l <= r){
            int m  = (l + r) >> 1;
            if(target <= nums[m % len]) r = m - 1;
            else l = m + 1;
        }
        return (nums[l % len] != target) ? -1 : l % len;
    }
}

