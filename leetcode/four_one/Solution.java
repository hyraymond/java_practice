package four_one;
import java.util.*;
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> con = new HashSet<Integer>();
        for (int i = 0; i < n; ++i)
        {
            if (nums[i] > 0)
            {
                con.add(nums[i]);
            }
        }
        int a = 1;
        while (true)
        {
            if (con.contains(a) == true)
            {
                ++a;
            }
            else
            {
                break;
            }
        }
        return a;
    }
}
