package one_two_eight;
import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> con = new HashSet<Integer>();
        int result = 0;

        for (int i = 0; i < n; ++i)
        {
            con.add(nums[i]);
        }
        
        for (Integer p: con)
        {
            int key = p;
            int temp = 0;
            if (con.contains(key-1) == true)
            {
                continue;
            }

            while (con.contains(key + temp))
            {
                ++temp;
            }

            result = Math.max(result, temp);
        }

        return result;
    }
}
