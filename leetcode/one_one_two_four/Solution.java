package one_one_two_four;

import java.util.*;
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        if (n == 0)
        {
            return 0;
        }

        int[] t = new int[n];
        int[] preSum = new int[n];
        for (int i = 0; i < n; ++i)
        {
            if (hours[i] > 8)
            {
                t[i] = 1;
            }
            else
            {
                t[i] = -1;
            }
            preSum[i] = i > 0? preSum[i-1] + t[i] : t[i]; 
        }

        Stack<Integer> con = new Stack<Integer>();
        for (int i = 0; i < n; ++i)
        {
            if (con.isEmpty() || preSum[con.peek()] > preSum[i])
            {
                con.add(i);
            }
        }
        int result = 0;
        for (int i = n - 1; i >= 0; --i)
        {
            while (!con.isEmpty() && preSum[i] > preSum[con.peek()])
            {
                result = Math.max(result, i - con.peek());
                con.pop();
            }
            if (preSum[i] > 0)
            {
                result = Math.max(result, i + 1);
                break;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] hours = {6, 6, 9};
        System.out.println(new Solution().longestWPI(hours));
    }
}