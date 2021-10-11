package two_seven_nine;
import java.util.*;
class Solution {
    public int numSquares(int n) {
        if (n == 0){
            return 0;
        }
        int key = (int)(Math.sqrt(n));
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; ++i){
            int temp = (int)(Math.sqrt(i));
            if (temp * temp == i){
                dp[i] = 1;
            }
            else{
                for (int j = 1; j <= key; ++j){
                    if (i - (j*j) > 0){
                        dp[i] = Math.min(dp[i], dp[i -(j*j)] + 1);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
