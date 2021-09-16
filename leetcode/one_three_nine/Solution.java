package one_three_nine;
import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> con = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <= n; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                String temp = s.substring(j, i);
                if (con.contains(temp) && dp[j] == true)
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args)
    {
        String s = "leetcode";
        List<String> wordDict = new LinkedList<String>() {{
            add("code");
            add("leet");
        }};
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
}
