package five_five_two;

import java.util.*;
class Solution {
    public int checkRecord(int n) {
        if (n == 0)
        {
            return 1;
        }

        final int c= (int)Math.pow(10, 3) + 7;
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; ++i)
        {
            for (int j = 0; j < 2; ++j)
            {
                for(int k = 0; k < 3; ++k)
                {
                    dp[i][j][0] = (dp[i-1][j][k] + dp[i][j][0]) %c;
                }
            }

            for (int j = 0; j < 2; ++j)
            {
                for (int k = 0; k < 2; ++k)
                {
                    dp[i][j][k+1] = (dp[i][j][k+1] + dp[i-1][j][k]) %c;
                }
            }
            for (int k = 0; k < 3; ++k)
            {
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k])%c;
            }
        }
        int result = 0;
        for (int j = 0; j < 2; ++j)
        {
            for (int k = 0; k < 3; ++k)
            {
                result = (result + dp[n][j][k])%c;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
    //     System.out.println(new Solution().checkRecord(1));
    //     System.out.println(new Solution().checkRecord(2));
    //     System.out.println(new Solution().checkRecord(3));
    //     System.out.println(new Solution().checkRecord(4));
        System.out.println(new Solution().checkRecord(10101));
    }
}
