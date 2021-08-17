package seven_nine;

import java.util.*;
// Self try, Only beats 5%.
class Solution {
    public boolean check(Map<Character, Integer> con, Map<Character, Integer> ron)
    {
        Set<Character> keys = ron.keySet();
        for (char p : keys)
        {
            if (con.containsKey(p) == false || con.get(p) < ron.get(p))
            {
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int start = 0;
        int end = 0;
        Map<Character, Integer> con = new HashMap<Character, Integer>();
        Map<Character, Integer> ron = new HashMap<Character, Integer>();
        String result = "";
        for (int i = 0; i < n; ++i)
        {
            if (ron.containsKey(t.charAt(i)) == false)
            {
                ron.put(t.charAt(i), 1);
            }
            else
            {
                int num = ron.get(t.charAt(i));
                ron.put(t.charAt(i), num+1);
            }
        }
        if (ron.containsKey(s.charAt(start)))
        {
            con.put(s.charAt(start), 1);
        }
        while(start < m)
        {
            if (con.size() == ron.size() && check(con, ron) == true)
            {
                String temp = s.substring(start, end+1);
                if (result == "" || result.length() > temp.length())
                {
                    result = temp;
                }
                Character te = s.charAt(start);
                if (con.containsKey(te) == true)
                {
                    if (con.get(te) > 1)
                    {
                        int val = con.get(te);
                        con.put(te, val-1);
                    }
                    else
                    {
                        con.remove(te);
                    }
                }
                ++start;
            }
            else if (end < m-1)
            {
                ++end;
                Character te = s.charAt(end);
                if(ron.containsKey(te) == true)
                {
                    if (con.containsKey(te) == true)
                    {
                        int val = con.get(te);
                        con.put(te, val+1);
                    }
                    else
                    {
                        con.put(te, 1);
                    }
                }
            }
            else
            {
                Character te = s.charAt(start);
                if (con.containsKey(te) == true)
                {
                    if (con.get(te) > 1)
                    {
                        int val = con.get(te);
                        con.put(te, val-1);
                    }
                    else
                    {
                        con.remove(te);
                    }
                }
                ++start;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        String s = "aa";
        String t= "aa";
        System.out.println(new Solution().minWindow(s, t));
    }
}


