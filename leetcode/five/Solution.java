//题目：leetcode5，给你一个字符串 s，找到 s 中最长的回文子串。
//思路：有两种回文子串，aa型和aba型，即中心为一个字符或者两个，遍历两次，分别按中心向两侧扩展。复杂度为O(n^2)
package five;
public class Solution {
    public String longestPalindrome(String s) {
        int max_length = 1, j = 0;
        int start_index = 0;

        if (s.length() < 2)
        {
            return s;
        }

        for (int i = 1; i < s.length() - 1; ++i)
        {
            j = 1;
            while(i - j >= 0 && i + j <= s.length() - 1)
            {
                if (s.charAt(i - j) == s.charAt(i + j))
                {
                    ++j;
                }
                else
                {
                    break;
                }
            }

            if ((2 * j - 1) > max_length)
            {
                start_index = i - j + 1;
                max_length = 2 * j - 1;
            }
        }

        for (int i = 0; i < s.length() - 1; ++i)
        {
            if (s.charAt(i) != s.charAt(i + 1))
            {
                continue;
            }

            j = 1;
            while(i - j >= 0 && i + j + 1 <= s.length() - 1)
            {
                if (s.charAt(i - j) == s.charAt(i + j + 1))
                {
                    ++j;
                }
                else
                {
                    break;
                }
            }

            if ((2 * j) > max_length)
            {
                start_index = i - j + 1;
                max_length = 2 * j;
            }
        }

        return s.substring(start_index, start_index + max_length);
    }
}