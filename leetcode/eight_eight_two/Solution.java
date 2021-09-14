package eight_eight_two;
import java.util.*;
class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int[][] matrix = new int[n][n];
        Integer[] arr = new Integer[n];
        int result = 1;
        for (int i = 0; i < n; ++i)
        {
            Arrays.fill(matrix[i], Integer.MAX_VALUE/2);
            arr[i] = i;
            matrix[i][i] = 0;
        }
        for (int i = 0; i < edges.length; ++i)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            int len = edges[i][2] + 1;
            matrix[a][b] = len;
            matrix[b][a] = len;
        }
        for (int i = 1; i < n; ++i)
        {
            int pk = matrix[0][arr[i]];
            int index = i;
            for (int j = i + 1; j < n; ++j)
            {
                if (pk > matrix[0][arr[j]])
                {
                    index = j;
                    pk = matrix[0][arr[j]];
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            if (matrix[0][arr[i]] <= maxMoves)
            {
                ++result;
            }
            for (int j = 0; j < n; ++j)
            {
                int len1 = matrix[0][j];
                int len2 = matrix[0][arr[i]] + matrix[arr[i]][j];
                matrix[0][j] = Integer.min(len1, len2); 
            }
        }
        for (int i = 0; i < edges.length; ++i)
        {
            int a = edges[i][0];
            int b = edges[i][1];
            int num = edges[i][2];
            int num1 = (maxMoves - matrix[0][a]) > 0?  (maxMoves - matrix[0][a]):0 ;
            int num2 = (maxMoves - matrix[0][b]) > 0?  (maxMoves - matrix[0][b]):0 ;
            num = (num1 + num2) > num? num: (num1 + num2);
            result += num;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] edges = {{1,2,4},{1,4,5},{1,3,1},{2,3,4},{3,4,5}};
        int maxMoves = 17;
        int n = 5;
        System.out.println(new Solution().reachableNodes(edges, maxMoves, n));
    }
}
