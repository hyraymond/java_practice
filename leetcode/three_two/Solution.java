package three_two;
// Longest Valid Parentheses, reference: https://leetcode-cn.com/problems/longest-valid-parentheses/
// Use Stack, reference: https://www.runoob.com/java/java-stack-class.html
// Solution1: self-made, very pool performance.
import java.util.*;

public class Solution {
    // Solution1:
    public static int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> pool = new Stack<Integer>();
        int[] dp = new int[n];
        int best = 0;
        Arrays.fill(dp, 0);

        for(int i = 0; i < n; ++i)
        {
            if (s.charAt(i) == '(')
            {
                dp[i] = i == 0? 0: dp[i - 1];
                pool.push(i);
            }
            else if (s.charAt(i) == ')')
            {
                if (pool.empty())
                {
                    dp[i] = 0;
                }
                else
                {
                    int pip = pool.peek();
                    if (i - pip + 1 == dp[i - 1] + 2)
                    {
                        dp[i] = dp[i - 1] + 2;
                    }
                    else
                    {
                        dp[i] = 2;
                    }

                    int key = pip;
                    if (key >= 1 && s.charAt(key - 1) == ')')
                    {
                        dp[i] += dp[key - 1];
                        key -= dp[key - 1];
                    }
                    pool.pop();
                }
            }
            best = best > dp[i] ? best: dp[i];
        }
        return best;
    }

    // Solution2:
    // public static int longestValidParentheses(String s) {
    //     int n = s.length();
    //     int best = 0;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, 0);

    //     for (int i = 1; i < n; ++i)
    //     {
    //         if (s.charAt(i) == ')') {
    //             if (s.charAt(i - 1) == '(') 
    //             {
    //                 dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
    //             } 
    //             else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') 
    //             {
    //                 dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
    //             }
    //             best = best < dp[i] ? dp[i] : best;
    //         }
    //     }

    //     return best;
    // }
    public static void main(String[] args)
    {
        String s = ")()())()()(";
        System.out.println(longestValidParentheses(s));
    }
}