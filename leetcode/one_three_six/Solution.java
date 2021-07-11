package one_three_six;

// Single Number

import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> table = new HashSet<Integer>();
        for (int k: nums)
        {
            if (table.contains(k) == true)
            {
                table.remove(k);
            }
            else
            {
                table.add(k);
            }
        }
        for (int k: table)
        {
            return k;
        }
        return 0;
    }
}
