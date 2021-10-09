package one_three_zero;
import java.util.*;
class Solution {
    private void check(char[][] board, int x, int y, int[][] visited){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return;
        }
        if (board[x][y] == 'X'){
            return;
        }
        if (visited[x][y] == 1){
            return;
        }
        visited[x][y] = 1;
        check(board, x-1, y, visited);
        check(board, x+1, y, visited);
        check(board, x, y-1, visited);
        check(board, x, y+1, visited);
    }
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0){
            return;
        }
        int n = board[0].length;
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; ++i){
            if (board[i][0] == 'O' && visited[i][0] == 0){
                check(board, i, 0, visited);
            }
            if (board[i][n-1] == 'O' && visited[i][n-1] == 0){
                check(board, i, n-1, visited);
            }
        }

        for (int j = 0; j < n; ++j){
            if (board[0][j] == 'O' && visited[0][j] == 0){
                check(board, 0, j, visited);
            }
            if (board[m-1][j] == 'O' && visited[m-1][j] == 0){
                check(board, m-1, j, visited);
            }
        }

        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if(board[i][j] == 'O' && visited[i][j] == 1){
                    board[i][j] = 'X';
                }
            }
        }
    }
}