package two_two_seven;
import java.util.*;
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<String> op = new Stack<String>();
        Stack<String> num = new Stack<String>();
        char[] str = s.toCharArray();
        Map<String, Integer> con = new HashMap<String, Integer>() {{
            put("+", 1);
            put("-", 1);
            put("*", 2);
            put("/", 2);
            put("(", 0);
        }};

        for (int i = 0; i < n; ++i)
        {
            if (Character.isDigit(str[i]))
            {
                if (i > 0 && Character.isDigit(str[i-1]))
                {
                    int k = Integer.parseInt(num.pop());
                    int l = Integer.parseInt(new Character(str[i]).toString());
                    int m = k*10 + l;
                    num.add(new Integer(m).toString());
                }
                else
                {
                    num.add(new Character(str[i]).toString());
                }
            }
            else if (str[i] == '(')
            {
                op.add(new Character(str[i]).toString());
            }
            else if (str[i] == ')')
            {
                String temp = op.pop();
                while (temp.compareTo("(") != 0)
                {
                    num.add(temp);
                    temp = op.pop();
                }
            }
            else if (str[i] == ' ')
            {
                continue;
            }
            else
            {
                int a = con.get(new Character(str[i]).toString());
                int b = op.isEmpty()? 0: con.get(op.peek());
                while (a <= b)
                {
                    String c = op.pop();
                    num.add(c);
                    b = op.isEmpty()? 0: con.get(op.peek());
                }
                op.add(new Character(str[i]).toString());
            }
        }

        while(!op.isEmpty())
        {
            String c = op.pop();
            num.add(c);
        }

        Stack<Integer> cal = new Stack<Integer>();

        for (String p: num)
        {
            if (p.compareTo("+") == 0 || p.compareTo("-") == 0 || p.compareTo("*") == 0 || p.compareTo("/") == 0)
            {
                int a = cal.pop();
                int b = cal.pop();
                int c = 0;
                if (p.compareTo("+") == 0)
                {
                    c = b + a;
                }
                else if (p.compareTo("-") == 0)
                {
                    c = b - a;
                }
                else if (p.compareTo("*") == 0)
                {
                    c = b*a;
                }
                else if (p.compareTo("/") == 0)
                {
                    c = b/a;
                }
                cal.add(c);
            }
            else
            {
                cal.add(Integer.parseInt(p));
            }
        }
        return cal.pop();
    }
    public static void main(String[] args)
    {
        String s = "2147483647";
        System.out.println(new Solution().calculate(s));
    }
}
