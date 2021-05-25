//Topic: A robot is located in the upper left corner of an m x n grid (the starting point is marked Start in the figure below). 
//The robot can only move down or right one step at a time and the robot tries to reach the lower right corner of the grid (marked Finish in the figure below). 
//How many different paths are there?Source: Leetcode link :https://leetcode-cn.com/problems/unique-paths 
//Solution: Dynamic Programing
package sixtytwo;
import java.util.*;

import javax.lang.model.util.ElementScanner14;
public class Solution{
    public static void main(String[] args){
        new Solution().uniquePaths(3,7);
    }
    public int uniquePaths(int m, int n) {
        int[][] dpTable = new int[m][n];
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (i - 1 >= 0 && j - 1 >= 0)
                {
                    dpTable[i][j] = dpTable[i][j] + dpTable[i-1][j] + dpTable[i][j-1];
                }
                else if (i - 1 >= 0 )
                {
                    dpTable[i][j] = dpTable[i][j] + dpTable[i-1][j];
                }
                else if (j - 1 >= 0)
                {
                    dpTable[i][j] = dpTable[i][j] + dpTable[i][j-1];
                }
                else
                {
                    dpTable[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                System.out.print(dpTable[i][j]+" ");
            }
            System.out.println("");
        }
        return dpTable[m-1][n-1];
    }
}
