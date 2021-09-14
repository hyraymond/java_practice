package nine_one_seven;
import java.util.*;
class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length() - 1;
        StringBuilder str = new StringBuilder(s);
        while(start < end)
        {
            if (!Character.isAlphabetic(s.charAt(start)))
            {
                ++start;
            }
            else if (!Character.isAlphabetic(s.charAt(end)))
            {
                --end;
            }
            else
            {
                char temp = str.charAt(start);
                str.insert(start, str.charAt(end));
                str.deleteCharAt(start);
                str.insert(end, temp);
                str.deleteCharAt(end);
                ++start;
                --end;
            }
        }
        return str.toString();
    }
}
