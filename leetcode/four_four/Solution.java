package four_four;

//Wildcard Matching
import java.util.*;
class Solution {
    private boolean match(String s, String p, int i, int j)
    {
        if (i == 0 || j == 0)
        {
            return false;
        }
        if (p.charAt(j-1) == '?')
        {
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean [][]dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 0; i <= m; ++i)
        {
            for (int j = 1; j <= n; ++j)
            {
                if (match(s, p, i, j) == true)
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (p.charAt(j-1) == '*')
                {
                    dp[i][j] = dp[i][j-1];
                    if (i - 1 >= 0)
                    {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
                else
                {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args)
    {
        String s = "aa";
        String p = "*";
        System.out.println(new Solution().isMatch(s, p));
    }
}