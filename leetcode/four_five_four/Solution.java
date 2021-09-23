package four_five_four;
import java.util.*;
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        Map<Integer, Integer> con1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> con2 = new HashMap<Integer, Integer>();
        int result = 0;
        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                int key = nums1[i] + nums2[j];
                int val = con1.getOrDefault(key, 0);
                con1.put(key, val+1);
            }
        }

        for (int i = 0; i < n; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                int key = nums3[i] + nums4[j];
                int val = con2.getOrDefault(key, 0);
                con2.put(key, val+1);
            }
        }

        for (Integer p: con1.keySet())
        {
            int a = con1.get(p);
            int b = con2.getOrDefault(-p, 0);
            result = result + (a * b);
        }

        return result;
    }
}
