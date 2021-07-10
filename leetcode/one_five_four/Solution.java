package one_five_four;

// 153. Find Minimum in Rotated Sorted Array

import java.util.*;
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        if (n == 1)
        {
            return nums[0];
        }

        while(start < end)
        {
            int mid = (start + end)/2;
            int temp = nums[mid];
            int tt = nums[n-1];
            if (temp <= tt)
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }

        return nums[start];
    }
}
