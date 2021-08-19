package two_two;

import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        List<String> result = new ArrayList<String>();
        check(n, n, temp, result);
        return result;
    }
    private void check(int a, int b, StringBuilder temp, List<String> result)
    {
        if (a == 0 && b == 0)
        {
            result.add(temp.toString());
        }

        if (a > 0)
        {
            temp.append('(');
            check(a-1, b, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }

        if (b > a)
        {
            temp.append(')');
            check(a, b-1, temp, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
