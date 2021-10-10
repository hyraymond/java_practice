package two_eight_zero;
import java.util.*;
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] result = new int[n];
        int start = 0;
        int end = n - 1;
        int i = 0;
        while(i < n){
            result[i++] = nums[start++];
            if (i < n) result[i++] = nums[end--];
        }

        for (int j = 0; j < n; ++j){
            nums[j] = result[j];
        }
    }
}
