package nine_six_two;

import java.util.*;
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        if (n == 0)
        {
            return 0;
        }

        Stack<Integer> con = new Stack<Integer>();
        for (int i = 0; i < n; ++i)
        {
            if (con.isEmpty() || nums[con.peek()] >= nums[i])
            {
                con.add(i);
            }
        }

        int result = 0;
        for (int i = n -1; i >= 0; --i)
        {
            if (con.isEmpty())
            {
                break;
            }
            int temp = con.isEmpty()? 0: con.peek();
            while (!con.isEmpty() && nums[i] >= nums[con.peek()])
            {
                temp = con.peek();
                con.pop();
                
            }
            if (nums[i] >= nums[temp])
            {
                int t = i - temp;
                result = Math.max(result, t);
            }
            
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] nums = {3, 4, 1, 2};
        System.out.println(new Solution().maxWidthRamp(nums));
    }
}