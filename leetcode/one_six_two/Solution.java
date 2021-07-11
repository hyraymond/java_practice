package one_six_two;

// Find Peak Element

import java.util.*;

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while(start < end)
        {
            int mid = (start + end)/2;
            int temp = nums[mid];
            if (temp < nums[mid + 1])
            {
                start = mid+1;
            }
            else
            {
                end = mid;
            }
        }
        return end;
    }
}

