package one_five_six_two;

import java.util.*;
class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int key = target[0];
        for (int i = 1; i < n; ++i)
        {
            int temp = target[i] - target[i-1] > 0? target[i] - target[i-1] : 0;
            key += temp;
        }
        return key;
    }
    
}
