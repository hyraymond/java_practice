package seven_six_nine;

import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; ++i)
        {
            temp = Math.max(temp, arr[i]);
            if (temp == i)
            {
                ++result;
            }
        }
        return result;
    }
}