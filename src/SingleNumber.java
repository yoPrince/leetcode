import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args){
        int[] nums = {4,1,2,1,2};
        System.out.println(new Solution().singleNumber(nums));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for( int i = 0; i < len; i++){
            if(map.get(nums[i]) == null) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }
       for( Integer key : map.keySet()){
           if(map.get(key) == 1) {
               ans = key;
               break;
           }
       }
        return ans;
    }
}