// Week challenge July 7th
//Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.
//Note that it is the kth smallest element in the sorted order, not the kth distinct element.

package July_7th;

import java.util.*;
import java.io.*;

class pos implements Comparable{
    int x;
    int y;
    int val;
    pos()
    {
        x = 0;
        y = 0;
        val = 0;
    }
    pos(int a, int b, int c)
    {
        x = a;
        y = b;
        val = c;
    }
    @Override
    public int compareTo(Object o) {
        int a = val;
        int b = ((pos) o).val;
        return a - b;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null)
        {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<pos> temp = new PriorityQueue<pos>();

        if (k == 1)
        {
            return matrix[0][0];
        }

        int[][] ifV = new int[m][n];
        ifV[0][0] = 1;
        temp.add(new pos(0, 0, matrix[0][0]));
        
        pos t = temp.peek();

        for (int i = 0; i < k; ++i)
        {
            t = temp.peek();
            temp.poll();
            if (t.x + 1 < m && ifV[t.x + 1][t.y] == 0)
            {
                temp.add(new pos(t.x + 1, t.y, matrix[t.x+1][t.y]));
                ifV[t.x+1][t.y] = 1;
            }
            if (t.y + 1 < m && ifV[t.x][t.y + 1] == 0)
            {
                temp.add(new pos(t.x, t.y + 1, matrix[t.x][t.y+1]));
                ifV[t.x][t.y+1] = 1;
            }
        }

        return t.val;
    }
    public static void main(String[] args)
    {
        int[][] matrix = {{1,2},{1,3}};
        System.out.println(new Solution().kthSmallest(matrix, 3));
    }
}