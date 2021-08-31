package seven_nine_two;

import java.util.*;
class Solution {
    class node
    {
        int index;
        String str;
        node(String a, int b)
        {
            str = a;
            index = b;
        }
    }
    public int numMatchingSubseq(String s, String[] words) {
        int n = 26;
        ArrayList<node> [] heads = new ArrayList[n];
        int result = 0;
        for (int i = 0; i < 26; ++i)
        {
            heads[i] = new ArrayList<node>();
        }

        for (String p: words)
        {
            if (p == null)
            {
                ++result;
                continue;
            }
            heads[p.charAt(0) - 'a'].add(new node(p, 0));
        }

        for (char p: s.toCharArray())
        {
            ArrayList<node> old_bucket = heads[p - 'a'];
            heads[p - 'a'] = new ArrayList<node>();

            for (node t: old_bucket)
            {
                t.index++;
                if (t.index == t.str.length())
                {
                    ++result;
                }
                else
                {
                    heads[t.str.charAt(t.index) - 'a'].add(t);
                }
            }
            old_bucket.clear();
        }
        return result;
    }
    public static void main(String[] args)
    {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        System.out.println(new Solution().numMatchingSubseq(s, words));
    }
}