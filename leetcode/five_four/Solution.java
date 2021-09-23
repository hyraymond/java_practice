package five_four;
import java.util.*;
class Solution {
    private void move(int[][] matrix, int[][] visited, int x, int y, int[] mode, List<Integer> result)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int temp = matrix[x][y];
        if (visited[x][y] == 0)
        {
            result.add(temp);
            visited[x][y] = 1;
        }

        int next_x = x;
        int next_y = y;
        if (result.size() == m * n)
        {
            return ;
        }
        if (mode[0] == 1)
        {
            if (next_y + 1>= n || visited[next_x][next_y+1] == 1)
            {
                mode[0] = 2;
            }
            else
            {
                next_y += 1;
            }
        }

        if (mode[0] == 2)
        {
            if (next_x + 1 >= m || visited[next_x+1][next_y] == 1)
            {
                mode[0] = 3;
            }
            else
            {
                next_x += 1;
            }
        }

        if (mode[0] == 3)
        {
            if (next_y - 1 < 0 || visited[next_x][next_y-1] == 1)
            {
                mode[0] = 4;
            }
            else
            {
                next_y -= 1;
            }
        }

        if (mode[0] == 4)
        {
            if (next_x - 1 < 0 || visited[next_x-1][next_y] == 1)
            {
                mode[0] = 1;
            }
            else
            {
                next_x -= 1;
            }
        }

        move(matrix, visited, next_x, next_y, mode, result);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        List<Integer> result = new ArrayList<Integer>();
        int[] mode = {1};
        move(matrix, visited, 0, 0, mode, result);
        return result;
    }
}
