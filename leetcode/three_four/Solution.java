package three_four;

// Find First and Last Position of Element in Sorted Array

// pass all data sets, beat 100%.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int n = nums.length;

        if (n == 0)
        {
            return result;
        }

        int p = binarySearch(nums, 0, n - 1, target);
        if (p == -1)
        {
            return result;
        }
        else
        {
            int ll = p - 1;
            while(-1 != binarySearch(nums, 0, ll, target))
            {
                --ll;
            }
            result[0] = ll + 1;

            int uu = p + 1;
            while(-1 != binarySearch(nums, uu, n -1, target))
            {
                ++uu;
            }
            result[1] = uu - 1;
        }
        return result;
    }
    int binarySearch(int[] nums, int b, int e, int target)
    {
        int h = (b+e)/2;
        int temp = nums[h];
        if (b < 0 || b > nums.length - 1 || e < 0 || e > nums.length - 1)
        {
            return -1;
        }
        if (b >= e)
        {
            if (nums[e] == target)
            {
                return e;
            }
            else
            {
                return -1;
            }
        }
        if (temp == target)
        {
            return h;
        }
        else if (temp > target)
        {
            return binarySearch(nums, b, h, target);
        }
        else
        {
            return binarySearch(nums, h+1, e, target);
        }
    }
    public static void main(String[] args)
    {
        int[] nums = {1};
        System.out.println(new Solution().searchRange(nums, 1));
    }
}
