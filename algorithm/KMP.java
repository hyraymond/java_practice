import java.util.*;

// first try 2021/06/23
// public class Solution {
//     private void getNext(int[] next, String needle)
//         {
//             int n = needle.length();
//             next[0] = -1;
//             int k = -1;
//             int j = 0;
    
//             while(j < n - 1)
//             {
//                 if (k == -1 || needle.charAt(k) == needle.charAt(j))
//                 {
//                     ++k;
//                     ++j;
//                     next[j] =k;
                    
//                 }
//                 else 
//                 {
//                     k = next[k];
//                 }
//             }
//         }
//         public int strStr(String haystack, String needle) {
//             int m = haystack.length();
//             int n = needle.length();
            
//             if (m == 0 && n == 0)
//             {
//                 return 0;
//             }
            
//             if (m == 0)
//             {
//                 return -1;
//             }
//             else if (n == 0)
//             {
//                 return 0;
//             }
            
//             int i = 0;
//             int j = 0;
//             int[] next = new int[n];
    
//             getNext(next, needle);
    
//             while (i < m && j < n)
//             {
//                 if (j == -1 || haystack.charAt(i) == needle.charAt(j))
//                 {
//                     ++i;
//                     ++j;
//                 }
//                 else
//                 {
//                     j = next[j];
//                 }
//             }
    
//             if (j >= n)
//             {
//                 return i - n;
//             }
//             else
//             {
//                 return -1;
//             }
//         }
//     }

// Second try 2021/06/16
public class KMP{
    private int[] getNext(String pattern)
    {
        int n = pattern.length();
        int[] next = new int[n];
        next[0] = -1;
        int i = 0;
        int k = -1;
        while(i < n - 1)
        {
            if (k == -1 || next[k] == next[i])
            {
                ++k;
                ++i;
                next[i] = k;
            }
            else
            {
                k = next[k];
            }
        }
        return next;
    }
    public int find(String target, String pattern)
    {
        int m = target.length();
        int n = pattern.length();
        int[] next = getNext(pattern);
        int p1 = 0;
        int p2 = 0;
        while(p1 < m && p2 < n)
        {
            if (p2 == -1 || target.charAt(p1) == pattern.charAt(p2))
            {
                ++p1;
                ++p2;
            }
            else
            {
                p2 = next[p2];
            }
        }
        if (p2 == n)
        {
            return p1 - n;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        String pattern = "ad";
        String target = "adfklsjabcalkfsdjkl";
        System.out.println(new KMP().find(target, pattern));
    }
}