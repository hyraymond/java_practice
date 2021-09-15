package seven_four_one;
import java.util.*;
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n+1][n+1];
        
        for (int i = 0; i <= n; ++i)
        {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[n-1][n-1] = grid[n-1][n-1];
        for (int k = 2 * n - 3; k >= 0; --k)
        {
            for (int i = Math.max(0, k-n+1); i <= Math.min((n-1), k); ++i)
            {
                for (int j = i; j <= Math.min((n-1), k); ++j)
                {
                    int y1 = k - i;
                    int y2 = k - j;
                    if (grid[i][y1] == -1 || grid[j][y2] == -1)
                    {
                        dp[i][j] = Integer.MIN_VALUE;
                    }
                    else
                    {
                        dp[i][j] = grid[i][y1] + Math.max(dp[i+1][j], Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i][j])));
                        if (i != j) dp[i][j] += grid[j][y2];
                    }
                }
            }
        }
        return Math.max(0, dp[0][0]);
    }
    public static void main(String[] args)
    {
        int[][] grid = {{1,1,-1},{1,-1,1},{-1,1,1}};
        System.out.println(new Solution().cherryPickup(grid));
    }
}