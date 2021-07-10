package July_5th;

//Reshape the Matrix

import java.util.*;

// Solution1, beats 24%
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int t = m * n;
        if (t != r * c)
        {
            return mat;
        }
        
        int[][] result = new int[r][c];
        for (int i = 0; i < t; ++i)
        {
            result[i/c][i%c] = mat[i/n][i%n];
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] mat = {{1,2},{3,4}};
        int r = 1;
        int c = 4;
        new Solution().matrixReshape(mat, r, c);
    }
}