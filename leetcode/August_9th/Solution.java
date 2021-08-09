package August_9th;

import java.util.*;
class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int key = 0;
        StringBuilder result = new StringBuilder();
        while(p1 >= 0 && p2 >= 0)
        {
            int temp1 = (int)(num1.charAt(p1) - '0');
            int temp2 = (int)(num2.charAt(p2) - '0');
            int temp = temp1 + temp2 + key;
            int remain = temp % 10;
            key = temp / 10;
            result.insert(0, (char)(remain + '0'));
            --p1;
            --p2;
        }
        if (p1 >= 0)
        {
            for (; p1 >= 0; --p1)
            {
                int temp1 = (int)(num1.charAt(p1) - '0');
                int temp = temp1 +  key;
                int remain = temp % 10;
                key = temp / 10;
                result.insert(0, (char)(remain + '0'));
                --p1;
            }
        }
        if (p2 >= 0)
        {
            for (; p2 >= 0; --p2)
            {
                int temp2 = (int)(num2.charAt(p2) - '0');
                int temp = temp2 +  key;
                int remain = temp % 10;
                key = temp / 10;
                result.insert(0, (char)(remain + '0'));
                --p2;
            }
        }
        if (key != 0)
        {
            result.insert(0, (char)(key + '0'));
        }
        return result.toString();
    }
    public static void main(String[] args)
    {
        String num1 = "9133";
        String num2 = "0";
        System.out.println(new Solution().addStrings(num1, num2));
    }
}
