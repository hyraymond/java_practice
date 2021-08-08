package offer_two_zero;
import java.util.*;
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int size = 0;
        int result = 0;
        for (int i = 0; i < n; ++i)
        {
            size = 0;
            while (i - size >= 0 && i + size < n && s.charAt(i-size) == s.charAt(i+size))
            {
                ++result;
                ++size;
            }
            size = 0;
            while (i - size >= 0 && i + 1 < n && i + 1 + size < n && s.charAt(i-size) == s.charAt(i+1+size))
            {
                ++result;
                ++size;
            }
        }
        return result;
    }
}