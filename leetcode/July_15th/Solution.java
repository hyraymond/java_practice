package July_15th;

// Valid Triangle Number
import java.util.*;
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int output = 0;

        for (int i = 0; i < n; ++i)
        {
            for (int j = i + 1; j < n; ++j)
            {
                for(int k = j + 1; k < n; ++k)
                {
                    if (nums[i] + nums[j] > nums[k])
                    {
                        ++output;
                    }
                }
            }
        }
        return output;
    }
}