package three_two_nine;

import java.util.*;
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
        {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        Integer[] arr = new Integer[m * n];
        int result = 0;

        for (int i = 0; i < arr.length; ++i)
        {
            arr[i] = i;
        }

        Arrays.sort(arr, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return matrix[o1/n][o1%n] - matrix[o2/n][o2%n];
            }
        });

        for (int i = 0; i < arr.length; ++i)
        {
            int index = arr[i].intValue();
            int x = index/n;
            int y = index%n;

            result = Math.max(result, dp[x][y]);
            if (x - 1 >= 0 && matrix[x-1][y] > matrix[x][y])
            {
                dp[x-1][y] = Math.max(dp[x-1][y], dp[x][y] + 1);
            }
            if (x + 1 < m && matrix[x+1][y] > matrix[x][y])
            {
                dp[x+1][y] = Math.max(dp[x+1][y], dp[x][y] + 1);
            }
            if (y - 1 >= 0 && matrix[x][y-1] > matrix[x][y])
            {
                dp[x][y-1] = Math.max(dp[x][y-1], dp[x][y] + 1);
            }
            if (y + 1 < n && matrix[x][y+1] > matrix[x][y])
            {
                dp[x][y+1] = Math.max(dp[x][y+1], dp[x][y] + 1);
            }
        }

        return result+1;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2}};
        System.out.println(new Solution().longestIncreasingPath(matrix));
    }
}
