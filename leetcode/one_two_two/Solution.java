package one_two_two;
import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0){
            return 0;
        }

        int max = 0;
        for (int i = 1; i < n; ++i){
            if (prices[i] - prices[i-1] > 0){
                max = max + (prices[i] - prices[i-1]);
            }
        }
        return max;
    }
}
