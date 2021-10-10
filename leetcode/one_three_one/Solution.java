package one_three_one;

import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if ((j==0) || (i-j >= 0 && i + j < n && s.charAt(i-j) == s.charAt(i+j) && dp[i-j+1][i+j-1] == true))
                {
                    dp[i-j][i+j] = true;
                }

                if (i + 1 < n && s.charAt(i) == s.charAt(i + 1))
                {
                    if ((j==0) || (i-j >= 0 && i + j + 1 < n && s.charAt(i-j) == s.charAt(i+j + 1) && dp[i-j+1][i+j] == true))
                    {
                        dp[i-j][i+j+1] = true;
                    }
                }
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        check(s, result, temp, dp, 0);
        return result;
    }
    private void check(String s, List<List<String>> result, List<String> temp, boolean[][] dp, int index)
    {
        int n = s.length();
        if (index == n)
        {
            result.add(new ArrayList<String>() {{
                addAll(temp);
            }});
        }
        for (int i = index; i < n; ++i)
        {
            if (dp[index][i] == true)
            {
                temp.add(s.substring(index, i+1));
                check(s, result, temp, dp, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
