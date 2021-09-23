package two_three_eight;
import java.util.*;
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        int temp = 1;
        for (int i = 0; i < n; ++i)
        {
            temp *= nums[i];
            begin[i] = temp;
        }
        temp = 1;
        for (int i = n-1; i >= 0; --i)
        {
            temp *= nums[i];
            end[i] = temp;
        }

        int[] result = new int[n];
        result[0] = end[1];
        result[n-1] = begin[n-2];
        for (int i = 1; i < n - 1; ++i)
        {
            result[i] = begin[i-1] * end[i+1];
        }
        return result;
    }
}