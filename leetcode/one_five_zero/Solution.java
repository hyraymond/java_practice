package one_five_zero;
import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> con = new Stack<Integer>();

        for (int i = 0; i < n; ++i)
        {
            String temp = tokens[i];
            if (temp.compareTo("+") == 0)
            {
                int a = con.pop();
                int b = con.pop();
                int c = a + b;
                con.add(c);
            }
            else if (temp.compareTo("-") == 0)
            {
                int a = con.pop();
                int b = con.pop();
                int c =  b- a;
                con.add(c);
            }
            else if (temp.compareTo("*") == 0)
            {
                int a = con.pop();
                int b = con.pop();
                int c = a * b;
                con.add(c);
            }
            else if (temp.compareTo("/") == 0)
            {
                int a = con.pop();
                int b = con.pop();
                int c = b / a;
                con.add(c);
            }
            else 
            {
                int t = Integer.parseInt(temp);
                con.add(t);
            }
        }
        return con.pop();
    }
}
