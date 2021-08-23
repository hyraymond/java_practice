package eight_five;

import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
        {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        int result = 0;
        int[] up = new int[m];
        int[] down = new int[m];
        Stack<Integer> con = new Stack<Integer>();

        for (int j = 0; j < n; ++j)
        {
            for (int i = 0; i < m; ++i)
            {
                if (matrix[i][j] == '0')
                {
                    left[i][j] = 0;
                }
                else 
                {
                    left[i][j] = (j == 0)? 0: left[i][j-1] + 1;
                }
            }
            con.clear();
            for (int i = 0; i < m; ++i)
            {
                while (!con.isEmpty() && left[i][j] <= left[con.peek()][j])
                {
                    con.pop();
                }
                int temp = con.isEmpty()? -1: con.peek();
                up[i] = temp;
                con.add(i);
            }
            con.clear();;
            for (int i = m-1; i >= 0; --i)
            {
                while (!con.isEmpty() && left[i][j] <= left[con.peek()][j])
                {
                    con.pop();
                }
                int temp = con.isEmpty()? m: con.peek();
                down[i] = temp;
                con.add(i);
                int s = (down[i] - up[i] - 1) * left[i][j];
                result = Math.max(s, result);
            }
        }

        return result;
    }
    public static void main(String[] args)
    {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new Solution().maximalRectangle(matrix));
    }
}