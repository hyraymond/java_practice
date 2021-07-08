package two_eight;

// Implement strStr().

// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

import java.util.*;

public class Solution {
    private void getNext(int[] next, String needle)
        {
            int n = needle.length();
            next[0] = -1;
            int k = -1;
            int j = 0;
    
            while(j < n - 1)
            {
                if (k == -1 || needle.charAt(k) == needle.charAt(j))
                {
                    ++k;
                    ++j;
                    next[j] =k;
                    
                }
                else 
                {
                    k = next[k];
                }
            }
        }
        public int strStr(String haystack, String needle) {
            int m = haystack.length();
            int n = needle.length();
            
            if (m == 0 && n == 0)
            {
                return 0;
            }
            
            if (m == 0)
            {
                return -1;
            }
            else if (n == 0)
            {
                return 0;
            }
            
            int i = 0;
            int j = 0;
            int[] next = new int[n];
    
            getNext(next, needle);
    
            while (i < m && j < n)
            {
                if (j == -1 || haystack.charAt(i) == needle.charAt(j))
                {
                    ++i;
                    ++j;
                }
                else
                {
                    j = next[j];
                }
            }
    
            if (j >= n)
            {
                return i - n;
            }
            else
            {
                return -1;
            }
        }
    }