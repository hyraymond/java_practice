package four_five_nine;

class Solution {
    private int[] getNext(String pattern)
    {
        int n = pattern.length();
        int[] next = new int[n];
        next[0] = -1;
        int i = 0;
        int k = -1;
        while(i < n - 1)
        {
            if (k == -1 || pattern.charAt(i) == pattern.charAt(k))
            {
                ++i;
                ++k;
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
        int p1 = 1;
        int p2 = 0;
        while (p1 < m && p2 < n)
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
            return p1 - p2;
        }
        return -1;
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 0)
        {
            return false;
        }
        int index = find(s + s, s);
        if (index == -1 || index == n)
        {
            return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        System.out.println(new Solution().repeatedSubstringPattern("bb"));
    }
}
