package July_12th;
// Isomorphic Strings

import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> table = new HashMap<Character, Character>();
        Map<Character, Character> aable = new HashMap<Character, Character>();
        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2)
        {
            return false;
        }

        for (int i = 0; i < n1; ++i)
        {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (table.containsKey(c1) == true)
            {
                if (c2 != table.get(c1))
                {
                    return false;
                }
            }
            else
            {
                table.put(c1, c2);
            }
            if (aable.containsKey(c2) == true)
            {
                if (c1 != aable.get(c2))
                {
                    return false;
                }
            }
            else
            {
                aable.put(c2, c1);
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        String s = "badc";
        String t = "baba";
        System.out.println(new Solution().isIsomorphic(s, t));
    }
}
