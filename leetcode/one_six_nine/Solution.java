package one_six_nine;

// Majority Element
import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        int n = nums.length;
        if (n == 1)
        {
            return nums[0];
        }
        for (int k: nums)
        {
            if (table.containsKey(k) == false)
            {
                table.put(k, 1);
            }
            else
            {
                int temp = table.get(k);
                if (temp + 1 > n/2)
                {
                    return k;
                }
                table.put(k, temp + 1);
            }
        }
        return 0;
    }
}
