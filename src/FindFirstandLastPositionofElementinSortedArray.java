import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args){
        int[] nums = {2,2};
        System.out.println(Arrays.toString(new Solution().searchRange(nums, 3)));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int m = (l + r) >> 1;
            if(target <= nums[m]) r = m - 1;
            else l = m + 1;
        }
        int first = -1, last = -1;
        if(l < nums.length && nums[l] == target){
            first = l;
            for(last = first; last < nums.length && nums[last] == target; last++);
            last--;
        }
        return new int[]{first, last};
    }
}