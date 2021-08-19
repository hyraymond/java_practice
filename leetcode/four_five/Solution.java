package four_five;

import java.util.*;
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 0)
        {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; ++i)
        {
            for (int j = i - 1; j >= 0; --j)
            {
                if (j + nums[j] >= i)
                {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n-1];
    }
}
