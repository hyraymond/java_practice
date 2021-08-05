package August_5th;

// let dp[i][j] represents the remain piles from i to j.
// In fact you can always win, just return true is ok.
import java.util.*;
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int size = 1; size <= n; ++size)
        {
            for (int i = 0; i < n - size + 1; ++i)
            {
                int j = i + size - 1;
                int parity = size;
                if (size == 1)
                {
                    dp[i][j] = -piles[i];
                }
                else
                {
                    if (parity % 2==0)
                    {
                        dp[i][j] = Math.max(piles[i] + dp[i + 1][j], piles[j] + dp[i][j-1]);
                    }
                    else
                    {
                        dp[i][j] = Math.min(-piles[i] + dp[i + 1][j], -piles[j] + dp[i][j-1]);
                    }
                }
            }
        }
        if (dp[0][n-1] > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args)
    {
        int[] piles = {5,3,4,5};
        new Solution().stoneGame(piles);
    }
}
