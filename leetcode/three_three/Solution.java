package three_three;

import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1)
        {
            return nums[n-1] == target ? n -1 :-1;
        }
        int key = findMin(nums);
        if (target == nums[key])
        {
            return key;
        }
        else if (target > nums[nums.length - 1])
        {
            return StandardBSearch(0, key - 1, target, nums);
        }
        else if (target < nums[nums.length - 1])
        {
            return StandardBSearch(key, nums.length - 1, target, nums);
        }
        else
        {
            return nums.length - 1;
        }
    }
    public int StandardBSearch(int b, int e, int target, int[] arr)
    {
        int n = arr.length;
        if (b < 0 || b > n - 1 || e < 0 || e > n -1)
        {
            return -1;
        }

        if (b >= e)
        {
            if (arr[e] == target)
            {
                return e;
            }
            else
            {
                return -1;
            }
        }

        int mid = (b + e) / 2;
        int temp = arr[mid];
        if (temp == target)
        {
            return mid;
        }
        else if (temp > target)
        {
            return StandardBSearch(b, mid - 1, target, arr);
        }
        else
        {
            return StandardBSearch(mid + 1, e, target, arr);
        }
    }
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

        return start;
    }
    public static void main(String[] args)
    {
        int[] nums = {1, 3};
        System.out.println(new Solution().search(nums, 0));
    }
}
