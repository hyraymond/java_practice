package January_1st;

// beat 100%
import java.util.*;
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int target = 0;
        int pattern = 0;
        int n = arr.length;
        int m = pieces.length;
        while (target < n)
        {
            int temp = 0;
            for (temp = 0; temp < m; ++temp)
            {
                if (pieces[temp][0] == arr[target])
                {
                    break;
                }
            }
            if (temp >= m)
            {
                return false;
            }
            for (int j = 0; j < pieces[temp].length; ++j)
            {
                if (pieces[temp][j] != arr[target])
                {
                    return false;
                }
                ++target;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        int[] arr = {85};
        int[][] pieces = {{85}};
        new Solution().canFormArray(arr, pieces);
    }
}