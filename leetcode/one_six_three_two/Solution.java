package one_six_three_two;
// Rank Transform of a Matrix, reference: https://leetcode-cn.com/problems/rank-transform-of-a-matrix/
// Map sort, reference: https://www.cnblogs.com/chenssy/p/3264214.html
// Map traverse, reference: https://blog.csdn.net/yueaini10000/article/details/78933289
// Little difference between C++ and Java, return a = 3;
import java.util.*;

class Solution {
    private static int[] father;
    private static Integer[] two2one(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        Integer[] arraymatrix = new Integer[m * n];
        for(int i = 0; i < m; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                arraymatrix[i * n + j] = i * n + j;
            }
        }
        return arraymatrix;
    }
    private static void union_ini(Integer[] arraymatrix)
    {
        father = new int[arraymatrix.length];
        for(int i = 0; i  < arraymatrix.length; ++i)
        {
            father[i] = i;
        }
    }
    private static int find_father(int index)
    {
        int pos = father[index];
        if (pos == index)
        {
            return index;
        }
        return father[index] = find_father(pos);
    }
    private static void union_merge(int lindex, int rindex)
    {
        int lpos = find_father(lindex);
        int rpos = find_father(rindex);
        if (lpos < rpos)
        {
            father[rpos] = lpos;
        }
        else if (lpos > rpos)
        {
            father[lpos] = rpos;
        }
    } 
    public static int[][] matrixRankTransform(int[][] matrix) {
        if (matrix.length == 0)
        {
            return null;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        Integer[] arraymatrix = two2one(matrix);
        int[] minRow = new int[matrix.length];
        int[] minCon = new int[matrix[0].length];
        int[] father_val = new int[m * n];
        Arrays.fill(minRow, -1);
        Arrays.fill(minCon, -1);

        Arrays.sort(arraymatrix, new Comparator<Integer>(){
            @Override
            public int compare(Integer lh, Integer rh)
            {
                return matrix[lh/n][lh%n] - matrix[rh/n][rh%n];
            }
        });

        union_ini(arraymatrix);
        for (int i = 0; i < arraymatrix.length; ++i)
        {
            int temp = arraymatrix[i];
            int row = temp/n;
            int col = temp%n;
            int val = 1;

            if (minRow[row] != -1)
            {
                int tempIndex = row * n + minRow[row];
                int leaderIndex = find_father(tempIndex);
                int leaderVal = father_val[leaderIndex];
                if (matrix[row][col] == matrix[row][minRow[row]])
                {
                    union_merge(leaderIndex, temp);
                    val = Math.max(val, leaderVal);
                }
                else
                {
                    val = Math.max(val, leaderVal + 1);
                }
            }
            if (minCon[col] != -1)
            {
                int tempIndex = minCon[col] * n + col;
                int leaderIndex = find_father(tempIndex);
                int leaderVal = father_val[leaderIndex];
                if (matrix[row][col] == matrix[minCon[col]][col])
                {
                    union_merge(leaderIndex, temp);
                    val = Math.max(val, leaderVal);
                }
                else
                {
                    val = Math.max(val, leaderVal + 1);
                }
            }
            
            minRow[row] = col;
            minCon[col] = row;
            int k = find_father(temp);
            father_val[k] = val;
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                ans[i][j] = father_val[find_father(index)];
            }
        }

        return ans;        
    }
    public static void main(String[] args)
    {
        int[][] matrix = {{20,-21,14},{-19,4,19},{22,-47,24},{-19,4,19}};
        int[][] result = matrixRankTransform(matrix);
        for(int i = 0; i < result.length; ++i)
        {
            for(int j = 0; j < result[0].length; ++j)
            {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}