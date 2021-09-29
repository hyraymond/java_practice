package one_three_three_one;
import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int key = 1;
        int[] result = new int[n];
        Integer[] num = new Integer[n];
        result[num[0]] = 1;

        Arrays.sort(num, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return arr[o1] - arr[o2];
            }
        });

        for (int i = 1; i < n; ++i)
        {
            if (arr[num[i]] == arr[num[i-1]]) result[i] = key;
            else result[i] = (++key);
        }

        return result;
    }
}
