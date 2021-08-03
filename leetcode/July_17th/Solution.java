package July_17th;

//Three Equal Parts
import java.util.*;
class Solution {
    static final int[] IMPOSSIBLE = {-1, -1};
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int total_one = 0;

        for (int p: arr)
        {
            if(p == 1) ++total_one;
        }

        if (total_one%3 != 0)
        {
            return IMPOSSIBLE;
        }

        int target_one = total_one/3;

        if(target_one == 0)
        {
            return new int[] {0, n - 1};
        }
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3= -1;
        int cur_one = 0;
        for (int i = 0; i < n; ++i)
        {
            if (arr[i] == 1)
            {
                ++cur_one;
                if (cur_one == 1) i1 = i;
                if (cur_one == target_one) j1 = i;
                if (cur_one == target_one + 1) i2 = i;
                if (cur_one == 2 * target_one) j2 = i;
                if (cur_one == 2 * target_one + 1) i3 = i;
                if (cur_one == 3 * target_one) j3 = i;
            }
        }
        int[] part1 = Arrays.copyOfRange(arr, i1, j1 + 1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2 + 1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3 + 1);

        if (!Arrays.equals(part1, part2) || !Arrays.equals(part2, part3))
        {
            return IMPOSSIBLE;
        }

        int trimLeft = i2 - j1 - 1;
        int trimMid = i3 - j2 - 1;
        int trimRight = n - j3 - 1;

        if (trimRight > Math.min(trimLeft, trimMid))
        {
            return IMPOSSIBLE;
        }

        return new int[] {j1 + trimRight, j2 + trimRight + 1};
    }
    public static void main(String[] args)
    {
        int[] arr = {0, 0, 0, 0, 0};
        int[] k = new Solution().threeEqualParts(arr);
        System.out.println("[" + k[0] + ", " + k[1] + "]");
    }
}
