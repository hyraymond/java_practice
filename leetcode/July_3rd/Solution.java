package July_3rd;
//Max Sum of Rectangle No Larger Than K

import java.util.*;

//Solution1, brute method, beat only 5%.
// class Solution {
//     public int maxSumSubmatrix(int[][] matrix, int k) {
//         int m = matrix.length;
//         int n = matrix[0].length;
//         int[][] table = new int[m][n];
//         for (int i = 0; i < m; i++)
//         {
//             for (int j = 0; j < n; j++)
//             {
//                 if (i == 0 && j == 0)
//                 {
//                     table[i][j] = matrix[i][j]; 
//                 }
//                 else if (i == 0)
//                 {
//                     table[i][j] = matrix[i][j] + table[i][j - 1];
//                 }
//                 else if (j == 0)
//                 {
//                     table[i][j] = matrix[i][j] + table[i - 1][j];
//                 }
//                 else
//                 {
//                     table[i][j] = matrix[i][j] + table[i - 1][j] + table[i][j-1] - table[i-1][j-1];
//                 }
//             }
//         }

//         int temp = Integer.MIN_VALUE;
//         for (int i = 0; i < m; ++i)
//         {
//             for (int j = 0; j < n; ++j)
//             {
//                 for (int p = i; p < m; ++p)
//                 {
//                     for (int q = j; q < n; ++q)
//                     {
//                         int t = check(i, j, p, q, table);
//                         if (t <= k)
//                         {
//                             temp = temp < t? t: temp;
//                         }
//                     }
//                 }
//             }
//         }
//         return temp;
//     }
//     int check(int x1, int y1, int x2, int y2, int[][] table)
//     {
//         if (x1 == 0 && y1 == 0)
//         {
//             return table[x2][y2];
//         }
//         else if (x1 == 0)
//         {
//             return table[x2][y2] - table[x2][y1-1];
//         }
//         else if (y1 == 0)
//         {
//             return table[x2][y2] - table[x1-1][y2];
//         }
//         else
//         {
//             return table[x2][y2] - table[x1-1][y2] - table[x2][y1-1] + table[x1-1][y1-1];
//         }
//     }
//     public static void main(String[] args)
//     {
//         int[][] matrix = {{2,2,-1}};
//         System.out.println(new Solution().maxSumSubmatrix(matrix, 3));
//     }
// }

// Solution2, rolling array, beats 12%
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] roll;
        TreeSet<Integer> wi;
        int temp = Integer.MIN_VALUE;

        for (int i = 0; i < m; ++i)
        {
            roll = new int[n];
            for (int j = i; j < m; ++j)
            {
                wi = new TreeSet<Integer>();
                wi.add(0);
                int s = 0;
                for (int c = 0; c < n; ++c)
                {
                    roll[c] += matrix[j][c];
                    s += roll[c];
                    Integer ceil = wi.ceiling(s - k);
                    if (ceil != null)
                    {
                        temp = temp < s - ceil? s - ceil: temp;
                    }
                    wi.add(s);
                }
            }
        }
        return temp;
    }
    public static void main(String[] args)
    {
        int[][] matrix = {{2,2,-1}};
        System.out.println(new Solution().maxSumSubmatrix(matrix, 0));
    }
}