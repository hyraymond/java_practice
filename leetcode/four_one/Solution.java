package four_one;
import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        while(i < n)
        {
            int key = nums[i];
            if (key > 0 && key <= n && key != i + 1 && nums[key-1] != key)
            {
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp - 1] = temp;
            }
            else 
            {
                ++i;
            }
        }
        for (j = 0; j < n; ++j)
        {
            if (nums[j] != j+1)
            {
                break;
            }
        }
        return j+1;
    }
    public static void main(String[] args)
    {
        int[] nums = {1, 1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}
