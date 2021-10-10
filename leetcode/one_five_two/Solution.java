package one_five_two;
import java.util.*;
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i){
            if (i == 0){
                min[i] = nums[i];
                max[i] = nums[i];
            }
            else{
                min[i] = Math.min(nums[i], Math.min(min[i-1]*nums[i], max[i-1]*nums[i]));
                max[i] = Math.max(nums[i], Math.max(min[i-1]*nums[i], max[i-1]*nums[i]));
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}