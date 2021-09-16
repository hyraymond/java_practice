package three_six;
import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; ++i)
        {
            Set<Character> con = new HashSet<Character>();
            for (int j = 0; j < n; ++j)
            {
                char temp = board[i][j];
                if ((!(temp >= '1' && temp <= '9') && temp != '.') || con.contains(temp))
                {
                    return false;
                }
                if (temp != '.') con.add(temp);
            }
        }

        for (int j = 0; j < n; ++j)
        {
            Set<Character> con = new HashSet<Character>();
            for (int i = 0; i < n; ++i)
            {
                char temp = board[i][j];
                if ((!(temp >= '1' && temp <= '9') && temp != '.') || con.contains(temp))
                {
                    return false;
                }
                if (temp != '.') con.add(temp);
            }
        }

        for (int i = 0; i < n * 3; i += 3)
        {
            Set<Character> con = new HashSet<Character>();
            int x = i/9 * 3;
            int y = i%9;
            for (int j = 0; j < n; ++j)
            {
                int x_ = x + j/3;
                int y_ = y + j%3;
                char temp = board[x_][y_];
                if ((!(temp >= '1' && temp <= '9') && temp != '.') || con.contains(temp))
                {
                    return false;
                }
                if (temp != '.') con.add(temp);
            }
        }
        return true;
    }
}