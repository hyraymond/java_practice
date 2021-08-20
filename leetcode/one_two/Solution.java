package one_two;

import java.util.*;
class Solution {
    public String intToRoman(int num) {
        int[] a = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] b = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int n = a.length;
        StringBuilder result = new StringBuilder();
        int temp = num;

        for (int i = 0; i < n; ++i)
        {
            int key = a[i];
            int p1 = temp/key;
            for (int j = 0; j < p1; ++j)
            {
                result.append(b[i]);
            }
            temp %= key;
        }
        return result.toString();
    }
}
