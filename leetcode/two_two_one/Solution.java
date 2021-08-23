package two_two_one;

import java.util.*;
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
        {
            return 0;
        }

        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (matrix[i][j] == '0')
                {
                    dp[i][j] = 0;
                }
                else
                {
                    int a = i-1 >= 0? dp[i-1][j]: 0;
                    int b = j-1 >= 0? dp[i][j-1]: 0;
                    int c = (i-1>=0 && j-1>=0)? dp[i-1][j-1]: 0;
                    dp[i][j] = Math.min(a, Math.min(b, c)) + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        return result * result;
    }
}
