package July_13th;

// find peek element
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1)
        {
            return 0;
        }
        int start = 0;
        int end = n - 1;
        while (start < end)
        {
            int mid = (start + end) >> 1;
            int temp = nums[mid];
            if (temp > nums[mid+1])
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }
        return end;
    }
}
