//题目：leetcode12，给定一个0-3999的数字，将其转换为罗马数字
//思路：数据驱动解法
package twelve;
public class Solution {
    public String intToRoman(int num) {
        int[] integer_table = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] string_table = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int sig = 0;
        int i = 0;
        StringBuilder result_string = new StringBuilder();

        while(0 != num)
        {
            sig = num/integer_table[i];
            num = num%integer_table[i];

            if (0 == sig)
            {
                ++i;
                continue;
            }

            while (sig > 0)
            {
                result_string.append(string_table[i]);
                --sig;
            }
        }

        return result_string.toString();
    }
}