package six_three_nine;

import java.util.*;
class Solution {
    public int numDecodings(String s) {
        final long c = 1000000007;
        int n = s.length();
        if (n == 0)
        {
            return 0;
        }

        long[] dp = new long[n];
        char temp = s.charAt(0);
        if (temp == '0')
        {
            dp[0] = 0;
        }
        else if (temp == '*')
        {
            dp[0] = 9;
        }
        else
        {
            dp[0] = 1;
        }

        for (int i = 1; i < n; ++i)
        {
            char cur = s.charAt(i);
            char pre = s.charAt(i-1);

            if (cur == '*') dp[i] = (dp[i] + 9 * dp[i-1]) %c;
            else if (cur != '0') dp[i] = (dp[i] + dp[i-1]) %c;

            long mu = i >= 2 ? dp[i-2]: 1;
            long me = 0;
            if (pre == '*' && cur == '*')
            {
                me = 15;
            }
            else if (pre == '*' && cur <= '6' && cur >= '0')
            {
                me = 2;
            }
            else if (pre == '*' && cur <= '9' && cur >= '7')
            {
                me = 1;
            }
            else if (pre == '1' && cur == '*')
            {
                me = 9;
            }
            else if (pre == '2' && cur == '*')
            {
                me = 6;
            }
            else if ((pre == '1' && cur <= '9' && cur >= '0') || (pre == '2' && cur <= '6' && cur >= '0'))
            {
                me = 1;
            }
            dp[i] = (dp[i] + me * mu)%c;
        }
        return (int)dp[n-1];
    }
}
