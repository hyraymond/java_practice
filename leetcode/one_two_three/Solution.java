package one_two_three;
import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0){
            return 0;
        }

        int [][]dp = new int[n][5];
        int max = 0;
        for (int i = 0; i < n; ++i){
            if (i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[i];
                dp[0][2] = 0;
                dp[0][3] = -prices[i];
                dp[0][4] = 0;
            }
            else{
                dp[i][0] = 0;
                dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
                dp[i][2] = Math.max(dp[i-1][1] + prices[i], dp[i-1][2]);
                dp[i][3] = Math.max(dp[i-1][2] + prices[i], dp[i-1][3]);
                dp[i][4] = Math.max(dp[i-1][3] + prices[i], dp[i-1][4]);
            }
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], Math.max(dp[n-1][2], Math.max(dp[n-1][3], dp[n-1][4]))));
    }
}
