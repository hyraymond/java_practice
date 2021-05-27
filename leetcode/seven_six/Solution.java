package seven_six;
// Minimum Window Substring, reference: https://leetcode-cn.com/problems/minimum-window-substring/
// Solution1: Use brute way to solve this problem, yet time limit exceeded at some cases.
// Solution2: Slide window, instead of like solution one, start from start to end, but both start to the right end.
import java.util.*;
class Solution {
    // private static int toIndex(char c)
    // {
    //     int index = 0;
    //     if (c < 'a')
    //     {
    //         index = (int)(c - 'A' + 26);
    //     }
    //     else
    //     {
    //         index = (int)(c - 'a');
    //     }
    //     return index;
    // }
    // private static int[] copyarray(int[] a)
    // {
    //     int n = a.length;
    //     int[] result = new int[n];
    //     for(int i = 0; i < n; ++i)
    //     {
    //         result[i] = a[i];
    //     }
    //     return result;
    // }
    // public static String minWindow(String s, String t) {
    //     int s_len = s.length();
    //     int t_len = t.length();
    //     int start = 0;
    //     int end = s_len - 1;
    //     String result = "";
    //     int[] pool_s = new int[52];
    //     int[] pool_t = new int[52];
    //     Arrays.fill(pool_t, 0);
    //     Arrays.fill(pool_s, 0);
    //     int best = s_len;
    //     int bstart = start;
    //     int bend = end;

    //     if (s_len < t_len)
    //     {
    //         return result;
    //     }

    //     for(int i = 0; i < s_len; ++i)
    //     {
    //         int index = toIndex(s.charAt(i));
    //         pool_s[index]++; 
    //     }
    //     for(int i = 0; i < t_len; ++i)
    //     {
    //         int index = toIndex(t.charAt(i));
    //         pool_t[index]++; 
    //         if (pool_t[index] > pool_s[index])
    //         {
    //             return result;
    //         }
    //     }

    //     int[] copy = copyarray(pool_s);
    //     for (start = 0; start < s_len; ++start)
    //     {
    //         if (start > 0)
    //         {
    //             int tex = toIndex(s.charAt(start - 1));
    //             copy[tex]--;
    //             if (copy[tex] < pool_t[tex])
    //             {
    //                 break;
    //             }
    //         }
    //         end = s_len - 1;
    //         pool_s = copyarray(copy);

    //         while(end >= start)
    //         {
    //             char temp = s.charAt(end);
    //             int index = toIndex(temp);
    //             if (pool_s[index] - 1 >= pool_t[index])
    //             {
    //                 pool_s[index]--;
    //                 --end;
    //             }
    //             else
    //             {
    //                 break;
    //             }
    //         }
    //         int value = end - start + 1;
    //         if (best > value)
    //         {
    //             best = value;
    //             bstart = start;
    //             bend = end;
    //         }
    //     }
        
    //     result = s.substring(bstart, bend + 1);
    //     return result;   
    // }
    private static int toIndex(char c)
    {
        int index = 0;
        if (c < 'a')
        {
            index = (int)(c - 'A' + 26);
        }
        else
        {
            index = (int)(c - 'a');
        }
        return index;
    }
    private static int[] copyarray(int[] a)
    {
        int n = a.length;
        int[] result = new int[n];
        for(int i = 0; i < n; ++i)
        {
            result[i] = a[i];
        }
        return result;
    }
    private static boolean check(int[] pool_s, int[] pool_t, String t)
    {
        int n = t.length();
        for(int i = 0; i  < n; ++i)
        {
            int index = toIndex(t.charAt(i));
            if (pool_s[index] < pool_t[index])
            {
                return false;
            }
        }
        return true;
    }
    public static String minWindow(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int start = 0;
        int end = start;
        String result = "";
        int[] pool_s = new int[52];
        int[] pool_t = new int[52];
        Arrays.fill(pool_t, 0);
        Arrays.fill(pool_s, 0);
        int best = s_len + 15;
        int bstart = start;
        int bend = end;

        if (s_len < t_len)
        {
            return result;
        }

        for(int i = 0; i < t_len; ++i)
        {
            int index = toIndex(t.charAt(i));
            pool_t[index]++; 
        }

        while(start < s_len)
        {
            if (check(pool_s, pool_t, t) == true || end >= s_len)
            {
                int temp = end - start;
                if (best > temp && check(pool_s, pool_t, t) == true)
                {
                    best = temp;
                    bstart = start;
                    bend = end;
                }
                int index = toIndex(s.charAt(start));
                pool_s[index]--;
                ++start;                
            }
            else
            {
                int index = toIndex(s.charAt(end));
                pool_s[index]++;
                ++end;    
            }
        }
        
        result = s.substring(bstart, bend);
        return result;   
    }
    public static void main(String[] args)
    {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
