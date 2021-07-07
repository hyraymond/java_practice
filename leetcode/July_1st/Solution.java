package July_1st;

// An n-bit gray code sequence is a sequence of 2n integers where:

// Every integer is in the inclusive range [0, 2n - 1],
// The first integer is 0,
// An integer appears no more than once in the sequence,
// The binary representation of every pair of adjacent integers differs by exactly one bit, and
// The binary representation of the first and last integers differs by exactly one bit.
// Given an integer n, return any valid n-bit gray code sequence.

import java.util.*;
import java.io.*;

//Solution one, DFS, pass all data sets. Only beats 20% of people.
// class Solution {
//     public List<Integer> grayCode(int n) {
//         List<Integer> result= new ArrayList<Integer>();
//         Set<Integer> table = new HashSet<Integer>();

//         result.add(0);
//         table.add(0);

//         che(n, result, table);

//         return result;
//     }
//     private boolean che(int n, List<Integer> result, Set<Integer> table)
//     {
//         if (1 << n == result.size())
//         {
//             return true;
//         }

//         int temp = result.get(result.size() - 1);
//         for (int i = 0; i < n; ++i)
//         {
//             int mask = 1 << i;
//             int new_temp = temp ^ mask;
//             if (table.contains(new_temp) == false)
//             {
//                 table.add(new_temp);
//                 result.add(new_temp);
//                 if (true == che(n, result, table))
//                 {
//                     return true;
//                 }
//                 table.remove(new_temp);
//                 result.remove(new_temp);
//             }
//         }
//         return false;
//     }
// }

// Solution two, Backtrace, pass all data sets. Beats 65% of people.
class Solution {
    public List<Integer> grayCode(int n) {
        return che(n);
    }
    private List<Integer> che(int n)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (n == 1)
        {
            result.add(0);
            result.add(1);
            return result;
        }

        List<Integer> temp = che(n - 1);
        result.addAll(temp);

        for(int i = temp.size() - 1; i >= 0 ; --i)
        {
            int mask = 1 << (n - 1);
            result.add(temp.get(i) ^ mask);
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(new Solution().grayCode(2));
    }
}