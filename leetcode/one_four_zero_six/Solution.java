package one_four_zero_six;
import java.util.*;
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        int[] f = new int[n+1];
        int sum = 0;

        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; --i)
        {
            sum+=stoneValue[i];
            f[i] = sum;
        }
        for (int i = n - 1; i >= 0; --i)
        {
            for (int j = i+1; j <= i+3 && j <= n; ++j)
            {
                dp[i] = Math.max(dp[i], f[i] - dp[j]);
            }
        }
        if (2 * dp[0] > sum)
        {
            return "Alice";
        }
        else if (2 * dp[0] == sum)
        {
            return "Tie";
        }
        else 
        {
            return "Bob";
        }
    }
    public static void main(String[] args)
    {
        int[] stoneValue = {1,2,3,-1,-2,-3,7};
        System.out.println(new Solution().stoneGameIII(stoneValue));
    }
}
