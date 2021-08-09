package August_8th;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private int[] oned(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m*n];
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                arr[i * n + j] = matrix[i][j];
            }
        }
        return arr;
    }
    private int getFather(int[] father, int index)
    {
        if (father[index] == index)
        {
            return index;
        }
        else
        {
            return getFather(father, father[index]);
        }
    }
    private void mergeFather(int[] father, int lindex, int rindex)
    {
        int lf = getFather(father, lindex);
        int rf = getFather(father, rindex);
        father[lf] = rf;
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];
        int[] arr = oned(matrix);
        Integer[] num = new Integer[m*n];
        int[] father = new int[m*n];
        int[] father_val = new int[m*n];
        for (int i = 0; i < num.length; ++i)
        {
            num[i] = i;
            father[i] = i;
        }

        Arrays.sort(num, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return arr[o1] - arr[o2];
            }
        });

        int[] min_row = new int[n];
        Arrays.fill(min_row, -1);
        int[] min_col = new int[m];
        Arrays.fill(min_col, -1);


        for (int i = 0; i < m*n; ++i)
        {
            int index = num[i];
            int index_x = index / n;
            int index_y = index % n;
            int temp = 1;
            int f = 0;
            if (min_row[index_y] != -1)
            {
                f = getFather(father, min_row[index_y]);
                if (arr[f] == arr[index])
                {
                    mergeFather(father, f, index);
                    temp = Math.max(temp, father_val[f]);
                }
                else
                {
                    temp = Math.max(temp, father_val[f] + 1);
                }
            }
            if (min_col[index_x] != -1)
            {
                f = getFather(father, min_col[index_x]);
                if (arr[f] == arr[index])
                {
                    mergeFather(father, f, index);
                    temp = Math.max(temp, father_val[f]);
                }
                else
                {
                    temp = Math.max(temp, father_val[f] + 1);
                }
            }
            min_row[index_y] = index;
            min_col[index_x] = index;
            father_val[index] = temp;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                result[i][j] = father_val[getFather(father, index)];
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] matrix = {{-37,-50,-3,44},{-37,46,13,-32},{47,-42,-3,-40},{-17,-22,-39,24}};
        // int[][] matrix = {{1, 2}, {3, 4}};
        new Solution().matrixRankTransform(matrix);
    }
}
