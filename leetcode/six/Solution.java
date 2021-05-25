//题目：leetcode6，将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//思路：根据数学关系按行访问，区分String，StringBuffer和StringBuilder在效率上的区别，进行取舍
package six;
public class Solution {
    public String convert(String s, int numRows) {
        int step = 0;
        int index = 0;
        int sig = 0;
        StringBuilder result_str = new StringBuilder();

        if (1 == numRows)
        {
            return s;
        }

        for (int i = 0; i < numRows; ++i)
        {
            index = i;
            sig = 0;
            while (index < s.length()) 
            {
                if (0 == sig) {
                    step = 2 * numRows - 2 - 2 * i;
                    sig = 1;
                }
                else {
                    step = 2 * i;
                    sig = 0;
                }

                if (0 == step) {
                    continue;
                }
                
                result_str.append(s.charAt(index));
                index += step;
            }
        }

        return result_str.toString();
    }
}