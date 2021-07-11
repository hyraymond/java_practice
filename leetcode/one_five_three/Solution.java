package one_five_three;

// Find minimum in rotated sorted array
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start < end)
        {
            int mid = (start + end) / 2;
            int temp = nums[mid];
            if (temp < nums[n - 1])
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
    public static void main(String[] args)
    {
        int[] nums = {3,4,5,1,2};
        System.out.println(new Solution().findMin(nums));
    }
}
