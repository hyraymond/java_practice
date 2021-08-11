package eight_zero_one;

import java.util.*;
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] keep = new int[n];
        int[] swap = new int[n];
        Arrays.fill(keep, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);
        keep[0] = 0;
        swap[0] = 1;
        for (int i = 1; i < n; ++i)
        {
            if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1])
            {
                keep[i] = keep[i-1];
                swap[i] = swap[i-1] + 1;
            }
            if (nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1])
            {
                keep[i] = Math.min(keep[i], swap[i-1]);
                swap[i] = Math.min(swap[i], keep[i-1]+1);
            }
        }
        return Math.min(keep[n-1], swap[n-1]);
    }
    public static void main(String[] args)
    {
        int[] nums1 = {1,8,4,6,7,8,16,18,19,29,25,26,35,31,38,35,37,41,39,43,48,49,46,47,50,52,54,55,63,58,67,63,69,71,74,73,76,77,80,78,79,80,86,87,90,93,95,96,97,100,101,105,106,108,108,109,116,111,119,121,122,124,130,125,126,127,128,140,144,135,148,151,143,154,155,157,160,156,158,159,168,170,163,173,175,176,177,180,177,182,183,184,185,190,191,194,194,195,196,200};
        int[] nums2 = {7,3,12,14,19,22,24,26,27,21,30,31,28,36,33,39,40,38,42,43,44,45,50,55,56,57,58,61,56,64,60,68,70,71,72,75,74,75,77,81,82,83,81,84,91,93,95,96,99,100,102,103,104,107,113,114,110,118,112,113,114,115,124,132,133,134,135,131,134,145,137,140,152,144,150,151,154,163,165,166,160,161,172,164,168,171,172,173,181,183,184,187,189,191,192,193,195,198,199,197};
        System.out.println(new Solution().minSwap(nums1, nums2));
    }
}
