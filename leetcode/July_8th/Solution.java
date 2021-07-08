package July_8th;

//Maximum Length of Repeated Subarray
//Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

// pass all data sets with just one shot, yet only beats 11%.
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] table = new int[m+1][n+1];
        int temp = 0;
        for (int i = 1; i <= m; ++i)
        {
            for (int j = 1; j <= n; ++j)
            {
                if (nums1[i-1] == nums2[j-1])
                {
                    table[i][j] = table[i - 1][j - 1] + 1;
                }
                else
                {
                    table[i][j] = 0;
                }
                temp = temp > table[i][j] ? temp : table[i][j];
            }
        }
        return temp;
    }
}
