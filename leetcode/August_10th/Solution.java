package August_10th;

import java.util.*;
class Solution {
    public int minFlipsMonoIncr(String s) {
        int z_n = 0;
        int n = s.length();
        int[] z_num = new int[n];
        for(int i = 0; i < n; ++i)
        {
            if (s.charAt(i) == '0')
            {
                ++z_n;
            }
            z_num[i] = z_n;
        }
        int temp = Integer.MAX_VALUE;
        int key = Integer.MAX_VALUE;
        for (int i = -1; i < n; ++i)
        {
            if (i == -1)
            {
                temp = z_n;
            }
            else
            {
                temp = i + 1 - z_num[i] + (z_n - z_num[i]);
            }
            key = temp < key? temp : key;
        }
        return key;
    }
    public static void main(String[] args)
    {
        String s = "00110";
        new Solution().minFlipsMonoIncr(s);
    }
}
