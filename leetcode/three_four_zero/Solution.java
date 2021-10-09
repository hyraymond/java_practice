package three_four_zero;
import java.util.*;
// 340, Longest Substring with At Most K Distinct Characters.
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] str_arr = s.toCharArray();
        if (str_arr == null){
            return 0;
        }

        int n = str_arr.length;
        int start = 0;
        int end = 0;
        int max = 0;
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        while (start <= end && end < n){
            int num = dict.size();
            if (num <= k){
                max = Math.max(max, end - start);
                char temp = str_arr[end];
                int count = dict.getOrDefault(temp, 0) + 1;
                dict.put(temp, count);
                ++end;
            }
            else{
                char temp = str_arr[start];
                int count = dict.get(temp) - 1;
                if (count == 0){
                    dict.remove(temp);
                }
                else{
                    dict.put(temp, count);
                }
                ++start;
            }
        }
        if (dict.size() <= k){
            max = Math.max(end - start, max);
        }
        return max;
    }
}
