package six_four_seven;

import java.util.*;
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;

        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if ((j==0) || (i-j >= 0 && i + j < n && s.charAt(i-j) == s.charAt(i+j) && dp[i-j+1][i+j-1] == true))
                {
                    dp[i-j][i+j] = true;
                    ++result;
                }

                if (i + 1 < n && s.charAt(i) == s.charAt(i + 1))
                {
                    if ((j==0) || (i-j >= 0 && i + j + 1 < n && s.charAt(i-j) == s.charAt(i+j + 1) && dp[i-j+1][i+j] == true))
                    {
                        dp[i-j][i+j+1] = true;
                        ++result;
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args)
    {
        String s = "aaa";
        System.out.println(new Solution().countSubstrings(s));
    }
}
