package five_five_one;

import java.util.*;
class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        if (n == 0)
        {
            return true;
        }

        int num = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i)
        {
            if (s.charAt(i) == 'A')
            {
                ++num;
            }
            else if (s.charAt(i) == 'L')
            {
                if (i == 0)
                {
                    dp[i] = 1;
                }
                else
                {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            else
            {
                dp[i] = 0;
            }

            if (dp[i] >= 3 || num >= 2)
            {
                return false;
            }
        }
        return true;
    }
}
