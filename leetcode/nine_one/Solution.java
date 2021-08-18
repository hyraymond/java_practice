package nine_one;

import java.util.*;
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
        {
            return 0;
        }

        int[] dp = new int[n];
        char temp = s.charAt(0);
        if (temp == '0')
        {
            dp[0] = 0;
        }
        else
        {
            dp[0] = 1;
        }

        for (int i = 1; i < n; ++i)
        {
            char cur = s.charAt(i);
            char pre = s.charAt(i-1);
            if (cur != '0') dp[i] += dp[i-1];
            int mu = i >= 2 ? dp[i-2]: 1;
            int me = 0;
            if ((pre == '1' && cur <= '9' && cur >= '0') || (pre == '2' && cur <= '6' && cur >= '0'))
            {
                me = 1;
            }
            dp[i] += (me * mu);
        }
        return dp[n-1];
    }
}
