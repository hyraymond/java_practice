package jianzhi_six_three;
import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0){
            return 0;
        }

        int min = prices[0];
        int max = 0;
        for (int i = 1; i < n; ++i){
            if (prices[i] > min){
                max = Math.max(max, prices[i]-min);
            }
            else{
                min = prices[i];
            }
        }
        return max;
    }
}
