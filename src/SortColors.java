public class SortColors {
   public static void main(String[] args){
       int[] nums = {2,0,2,1,1,0};
       new Solution().sortColors(nums);
   }
}

class Solution {
   public void sortColors(int[] nums) {
       int len = nums.length;
       int[] cnt = {0, 0, 0};
       for( int i = 0; i < len; i++) cnt[nums[i]]++;
       int k = 0;
       for( int i = 0; i < 3; i++){
           for( int j = 0; j < cnt[i]; j++){
               nums[k++] = i;
           }
       }
   }
}