package three_five_four;

import java.util.*;
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0)
        {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[0] != o2[0])
                {
                    return o1[0] - o2[0];
                }
                else
                {
                    return o1[1] - o2[1];
                }
            }
            
        });
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < n; ++i)
        {
            for (int j = i - 1; j >= 0; --j)
            {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] envelopes = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        System.out.println(new Solution().maxEnvelopes(envelopes));
    }
}