package three_zero_nine;
import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][3];
        int result = 0;

        for (int i = 0; i < n; ++i){
            if (i == 0){
                dp[i][0] = -prices[i];
                dp[i][1] = 0;
                dp[i][2] = 0;
            }
            else{
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
                dp[i][1] = dp[i-1][0] + prices[i];
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
            }
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }
}
