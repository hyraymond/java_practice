package five_two;

import java.util.*;
class Solution {
    int result = 0;
    boolean check(char[][] board, int row, int col)
    {
        int n = board.length;
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < col; ++j)
            {
                if ((board[i][j] == 'Q') && (i == row || j == col || i + j == row + col || i + col == j + row))
                {
                    return false;
                }
            }
        }
        return true;
    }
    void pick(char[][] board, int i)
    {
        int n = board.length;
        if (i == n)
        {
            ++result;
        }
        for (int j = 0; j < n; ++j)
        {
            if (check(board, j, i))
            {
                board[j][i] = 'Q';
                pick(board, i+1);
                board[j][i] = '*';
            }
        }
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                board[i][j] = '*';
            }
        }
        pick(board, 0);

        return result;
    }
    public static void main(String[] args)
    {
        new Solution().totalNQueens(2);
    }
}
