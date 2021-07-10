package July_4th;

// Count Vowels Permutation

import java.util.*;

// Solution1 time limit exceeded
// class Solution {
//     int[][] as = {{1}, {0, 2},{0, 1, 3, 4},{2, 4},{0}};
//     int k = 0;
//     public int countVowelPermutation(int n) {
//         if (n == 1)
//         {
//             return 5;
//         }
//         for (int i = 0; i < 5; ++i)
//         {
//             check(n, 2, i);
//         }
//         return k;
//     }
//     private void check(int n, int i, int pre)
//     {
//         if (i == n)
//         {
//             k = (as[pre].length + k)%(1000000007);
//             return;
//         }
//         else
//         {
//             for (int q = 0; q < as[pre].length; ++q)
//             {
//                 check(n, i + 1, as[pre][q]);
//             }
//         }
//     }
//     public static void main(String[] args)
//     {
//         int n = 5;
//         System.out.println(new Solution().countVowelPermutation(n));
//     }
// }

// Solution2, dp, pass all data sets, beats 53%
class Solution {
    int[][] as = {{1}, {0, 2},{0, 1, 3, 4},{2, 4},{0}};
    int[][] sa = {{1, 2, 4}, {0, 2}, {1, 3}, {2}, {2, 3}};
    int mod = (int)Math.pow(10,9) + 7;
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n][5];
        int temp = 0;

        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < 5; ++j)
            {
                if (i == 0)
                {
                    dp[i][j] = 1;
                    if (i == n-1)
                    {
                        temp = (temp + dp[i][j])%mod;
                    }
                    continue;
                }
                for (int q = 0; q < sa[j].length; ++q)
                {
                    int y = sa[j][q];
                    dp[i][j] = (dp[i][j] + dp[i-1][y])%mod;
                }
                if (i == n-1)
                {
                    temp = (temp + dp[i][j])%mod;
                }
            }
        }
        return temp;
    }
    public static void main(String[] args)
    {
        int n = 144;
        System.out.println(new Solution().countVowelPermutation(n));
    }
}