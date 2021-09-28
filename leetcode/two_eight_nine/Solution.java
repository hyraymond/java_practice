package two_eight_nine;
import java.util.*;
class Solution {
    private int check(int[][] board, int x, int y)
    {
        int temp = 0;
        int m = board.length;
        int n = board[0].length;
        int[] a = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] b = {1, -1, 1, 0, -1, 1, 0, -1};
        for (int i = 0; i < 8; ++i)
        {
            int next_x = x+a[i];
            int next_y = y+b[i];
            if (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n && board[next_x][next_y] == 1)
            {
                ++temp;
            }
        }
        return temp;
    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                int temp = check(board, i, j);
                if (temp < 2)
                {
                    result[i][j] = 0;
                }
                else if (board[i][j] == 0 && temp == 3)
                {
                    result[i][j] = 1;
                }
                else if (temp < 4)
                {
                    result[i][j] = board[i][j];
                }
                else
                {
                    result[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                board[i][j] = result[i][j];
            }
        }
    }
    public static void main(String[] args)
    {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new Solution().gameOfLife(board);
    }
}