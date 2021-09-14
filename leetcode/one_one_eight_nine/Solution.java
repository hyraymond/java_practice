package one_one_eight_nine;
import java.util.*;
class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = "ballon".length();
        Map<Character, Integer> con = new HashMap<Character, Integer>() {{
            put('a', 1);
            put('b', 1);
            put('l', 2);
            put('o', 2);
            put('n', 1);
        }};
        Map<Character, Integer> temp = new HashMap<Character, Integer>();
        for (char p: text.toCharArray())
        {
            if (con.containsKey(p))
            {
                int num = temp.getOrDefault(p, 0);
                temp.put(p, num + 1);
            }
        }
        int result = Integer.MAX_VALUE;
        for (char p: temp.keySet())
        {
            int a = con.get(p);
            int b = temp.get(p);
            int c = a <= b ? b/a: 0;
            result = Math.min(result, c);
        }
        result = temp.size() == con.size()? result: 0;
        return result;
    }
    public static void main(String[] args)
    {
        String text = "loonbalxballpoon";
        System.out.println(new Solution().maxNumberOfBalloons(text));
    }
}