package six_nine_five;
import java.util.*;
class Solution {
    private int dfs(int[][] grid, int x, int y)
    {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
        {
            return 0;
        }

        int[] xoffset = {0, 0, 1, -1};
        int[] yoffset = {1, -1, 0, 0};
        int ans = 1;
        grid[x][y] = 0;
        for (int i = 0; i < 4; ++i)
        {
            int next_x = x + xoffset[i];
            int next_y = y + yoffset[i];
            ans += dfs(grid, next_x, next_y);
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                result = Math.max(result, dfs(grid, i, j));
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] grid = {{0, 1}, {0, 1}};
        System.out.println(new Solution().maxAreaOfIsland(grid));
    }
}