package one_five_one_zero;
import java.util.*;
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        for (int i = 1; i <= n; ++i)
        {
            int k = 1;
            while (i - (k*k) >= 0)
            {
                if (dp[i-(k*k)] == false)
                {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
