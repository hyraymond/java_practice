package one_eight_eight;

import java.util.*;
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k <= 0)
        {
            return 0;
        }

        int n = prices.length;
        if(n == 0)
        {
            return 0;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        for (int i = 0; i < k; ++i)
        {
            buy[i] = -prices[0];
        }
        int temp = 0;
        for (int i = 1; i < n; ++i)
        {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            // temp = temp < sell[0] ? sell[0]: temp;
            for (int j = 1; j < k; ++j)
            {
                buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
                // temp = temp < sell[j] ? sell[j]: temp;
            }
        }

        for (int i = 0; i < k; ++i){
            temp = Math.max(temp, sell[i]);
        }
        return temp;
    }
    public static void main(String[] args)
    {
        int k = 2;
        int[] prices = {3,2,6,5,0,3};
        System.out.println(new Solution().maxProfit(k, prices));
    }
}
