package four_two;

//Trapping Rain Water
import java.util.*;
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int start = 0;
        int end = n -1;
        int temp = 0;

        if (n <= 2)
        {
            return 0;
        }

        while(start < end)
        {
            int st = 0;
            if (height[start] < height[end])
            {
                st = height[start];
                ++start;
                if (height[start] < st)
                {
                    temp += (st - height[start]);
                    height[start] = st;
                }
                else
                {
                    st = height[start];
                }
            }
            else
            {
                st = height[end];
                --end;
                if (height[end] < st)
                {
                    temp += (st - height[end]);
                    height[end] = st;
                }
                else
                {
                    st = height[end];
                }
            }
        }

        return temp;
    }
    public static void main(String[] args)
    {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(height));
    }
}
