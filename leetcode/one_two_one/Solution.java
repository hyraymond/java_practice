package one_two_one;
import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0){
            return 0;
        }

        int max = 0;
        int min = prices[0];
        int temp = 0;
        for (int i = 1; i < n; ++i){
            if (prices[i] > min){
                temp = prices[i] - min;
                max = Math.max(temp, max);
            }
            else{
                min = prices[i];
            }
        }
        return max;
    }
}
