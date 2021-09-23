package one_one;
import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0;
        int end = n -1;
        int result = 0;
        while (start < end)
        {
            int theight = Math.min(height[start], height[end]);
            int len = end - start;
            int temp = theight * len;
            result = Math.max(result, temp);
            if (height[start] <= height[end])
            {
                ++start;
            }
            else
            {
                --end;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] height = {1,8,100,2,100,4,8,3,7};
        System.out.println(new Solution().maxArea(height));
    }
}
