package July_14th;

import java.util.*;
class Solution {
    private Character[] str2array(String order)
    {
        int n = order.length();
        Character[] s = new Character[n];
        for (int i = 0; i < n; ++i)
        {
            s[i] = order.charAt(i);
        }
        return s;
    }
    public String customSortString(String order, String s) {
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        int n = order.length();
        for (int i = 0; i < n; ++i)
        {
            table.put(order.charAt(i), i);
        }
        Character[] as = str2array(s);
        Arrays.sort(as, new Comparator<Character>(){

            @Override
            public int compare(Character o1, Character o2) {
                int a1 = table.get(o1) == null? -1: table.get(o1);
                int a2 = table.get(o2) == null? -1: table.get(o2);
                return a1 - a2;
            }
        });
        StringBuilder kk = new StringBuilder();
        int m = as.length;
        for (int i = 0; i < m; ++i)
        {
            kk.append(as[i]);
        }
        return kk.toString();
    }
    public static void main(String[] args)
    {
        String order = "cba";
        String s = "abcd";
        System.out.println(new Solution().customSortString(order, s));
    }
}
