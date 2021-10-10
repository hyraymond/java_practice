
import java.util.*;
class Solution {
    private boolean dfs(char[][] board, String word, int x, int y, int i, int[][] visited){
        if (i >= word.length() || x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return false;
        }
        if (board[x][y] != word.charAt(i)){
            return false;
        }
        if (visited[x][y] == 1){
            return false;
        }
        if (board[x][y] == word.charAt(i) && i == word.length() -1){
            return true;
        }
        visited[x][y] = 1;
        boolean result = dfs(board, word, x-1, y, i+1, visited) || dfs(board, word, x+1, y, i+1, visited) ||
                        dfs(board, word, x, y-1, i+1, visited) || dfs(board, word, x, y+1, i+1, visited);
        visited[x][y] = 0;
        return result;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (word == null){
            return true;
        }
        if(m == 0){
            return false;
        }
        int n = board[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (true == dfs(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
