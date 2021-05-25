//题目：leetcode17，给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//思路：很好的复习了回溯法，类似于那个全排列练习，需要注意的是通过工厂函数初始化Map
package seventeen;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character, String> table = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs",
                                            '8', "tuv", '9', "wxyz");
        if (0 == digits.length())
        {
            return result;
        }
        traceBack(digits, 0, result, table, new StringBuilder());
        return result;
    }
    void traceBack(String digits, int index, List<String> result, Map<Character, String> table, StringBuilder combination)
    {
        if (index == digits.length())
        {
            result.add(combination.toString());
            return;
        }
        Character num = digits.charAt(index);
        String lettercount = table.get(num);
        for(int i = 0; i < lettercount.length(); ++i)
        {
            combination.append(lettercount.charAt(i));
            traceBack(digits, index + 1, result, table, combination);
            combination.delete(index, index + 1);        
        }
    }
    public static void main(String[] args)
    {
        System.out.println(new Solution().letterCombinations("23"));
    }
}