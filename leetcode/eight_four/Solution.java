package eight_four;

import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0)
        {
            return 0;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int result = 0;
        Stack<Integer> con = new Stack<Integer>();

        for (int i = 0; i < n; ++i)
        {
            while (!con.isEmpty() && heights[i] <= heights[con.peek()])
            {
                con.pop();
            }
            int temp = con.isEmpty()? -1: con.peek();
            left[i] = temp;
            con.add(i);
        }
        con.clear();

        for (int i = n - 1; i >= 0; --i)
        {
            while (!con.isEmpty() && heights[i] <= heights[con.peek()])
            {
                con.pop();
            }
            int temp = con.isEmpty()? n: con.peek();
            right[i] = temp;
            con.add(i);
            int p = (right[i] - left[i] - 1) * heights[i];
            result = result < p? p: result;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] heights = {0, 9};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}