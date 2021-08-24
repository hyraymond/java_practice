package seven_six_eight;

import java.util.*;
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        if (n == 0)
        {
            return 0;
        }

        int[] p = Arrays.copyOf(arr, n);
        Arrays.sort(p);

        int result = 0;
        int non_zero = 0;
        Map<Integer, Integer> con = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i)
        {
            int a = arr[i];
            int b = p[i];

            con.put(a, con.getOrDefault(a, 0) + 1);
            if (con.get(a) == 0)
            {
                --non_zero;
            }
            else if (con.get(a) == 1)
            {
                ++non_zero;
            }

            con.put(a, con.getOrDefault(b, 0) - 1);
            if (con.get(b) == 0)
            {
                --non_zero;
            }
            else if (con.get(b) == -1)
            {
                ++non_zero;
            }

            if (non_zero == 0)
            {
                ++result;
            }
        }
        return result;
    }
}
