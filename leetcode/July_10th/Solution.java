package July_10th;

//Decode Ways II

import java.util.*;
class Solution {
    long[] dp;
    int mod = 1000000007;
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0)
        {
            return 0;
        }
        dp = new long[n];
        if (n >= 1)
        {
            dp[0] = check(0, 0, s) % mod;
        }
        if (n >= 2)
        {
            dp[1] = (check(0, 1, s) + check(1, 1, s) * dp[0]) % mod;
        }
        if (n >= 3)
        {
            for (int i = 2; i < n; ++i)
            {
                dp[i] = ((check(i - 1, i, s ) * dp[i - 2]) % mod + (check(i, i, s) * dp[i - 1]) % mod)%mod;
            }
        }
        return (int) dp[n - 1];
    }
    public int check(int b, int e, String s)
    {
        if (s.charAt(b) == '0')
        {
            return 0;
        }

        if (e - b == 0)
        {
            if (s.charAt(b) == '*')
            {
                return 9;
            }
            return 1;
        }
        else if (e - b == 1)
        {
            if (s.charAt(b) == '*' && s.charAt(e) == '*')
            {
                return 15;
            }
            else if (s.charAt(e) == '*')
            {
                if (s.charAt(b) == '1')
                {
                    return 9;
                }
                else if(s.charAt(b) == '2')
                {
                    return 6;
                }
            }
            else if (s.charAt(b) == '*')
            {
                if (s.charAt(e) <= '6')
                {
                    return 2;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                int ll = Integer.parseInt(s.substring(b, e + 1));
                if (ll <= 26)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args)
    {
        String s = "7*9*3*6*3*0*5*4*9*7*";
        System.out.println(new Solution().numDecodings(s));
    }
}
