package three_zero_one;
import java.util.*;
class Solution {
    char[] str;
    StringBuilder temp;
    Set<String> list;
    private void dfs(int index, int leftmove, int rightmove, int leftcount, int rightcount){
        int n = str.length;
        if (leftcount < 0){
            return;
        }
        if (index == n){
            if (leftcount == 0){
                list.add(temp.toString());
            }
            return;
        }

        if (str[index] == '(' && leftmove > 0){
            dfs(index+1, leftmove-1, rightmove, leftcount, rightcount);
        }
        else if (str[index] == ')' && rightmove > 0){
            dfs(index+1, leftmove, rightmove-1, leftcount, rightcount);
        }

        temp.append(str[index]);
        if (str[index] == '(') ++leftcount;
        else if (str[index] == ')'){
            --leftcount;
            ++rightcount;
        }
        dfs(index+1, leftmove, rightmove, leftcount, rightcount);
        temp.deleteCharAt(temp.length() - 1);
    }
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        str = s.toCharArray();
        list = new HashSet<String>();
        List<String> result = new ArrayList<>();
        temp = new StringBuilder();
        int leftcount = 0;
        int rightcount = 0;
        for (int i = 0; i < n; ++i){
            if (str[i] == '('){
                ++leftcount;
            }
            else if (str[i] == ')'){
                if (leftcount > 0)--leftcount;
                ++rightcount;
            }
        }
        dfs(0, leftcount, rightcount, 0, 0);
        for (String p : list){
            result.add(p);
        }

        return result;
    }
    public static void main(String[] args){
        String s = ")(";
        System.out.println(new Solution().removeInvalidParentheses(s));
    }
}
