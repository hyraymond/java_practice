package one_one_four_zero;
import java.util.*;
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n+1];
        int sum = 0;
        for (int i = n - 1; i >= 0; --i)
        {
            sum += piles[i];
            for (int M = 1; M <= n; ++M)
            {
                if (i + 2 * M >= n)
                {
                    dp[i][M] = sum;
                }
                else
                {
                    for (int x = 1; x <= 2 * M; ++x)
                    {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i+x][Math.max(x, M)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
