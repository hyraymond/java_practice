package five_five;

import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int key = 0;
        for (int i = 0; i < n; ++i)
        {
            int len = nums[i];
            if (i <= key)
            {
                int temp = i + len;
                key = Math.max(key, temp);
            }
            else
            {
                break;
            }
            if (key >= n-1)
            {
                break;
            }
        }
        return key >= n - 1;
    }
}
