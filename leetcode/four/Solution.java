package four;
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// Follow up: The overall run time complexity should be O(log (m+n)).
public class Solution {
    public static void main(String[] args)
    {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int index = (m+n)/2;
        int pos1=0;
        int pos2=0;
        int result1 = 0;
        int result2 = 0;

        for (int i = 0; i <= index; ++i)
        {
            if (pos1 >= m)
            {
                result2 = nums2[pos2++];
            }
            else if (pos2 >= n)
            {
                result2 = nums1[pos1++];
            }
            else if (nums1[pos1] < nums2[pos2])
            {
                result2 = nums1[pos1++];
            }
            else
            {
                result2 = nums2[pos2++];
            }

            if (i == index-1)
            {
                result1 = result2;
            }
        }
        if ((m+n)%2 == 0)
        {
            return ((double)result1+(double)result2)/2;
        }
        else
        {
            return result2;
        }
    }
    
}
