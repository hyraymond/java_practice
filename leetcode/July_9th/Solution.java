package July_9th;

//Longest Increasing Subsequence

import java.util.*;

// pass all data sets, only beats 5% of people.
class Solution {
    List<Integer> tem;
    int[] dp;
    private void add(int a)
    {
        if (tem.isEmpty())
        {
            tem.add(a);
            return;
        }
        else
        {
            int i = 0;
            for (i = 0; i < tem.size(); ++i)
            {
                if (dp[tem.get(i)] < dp[a])
                {
                    tem.add(i, a);
                    return;
                }
            }
            tem.add(a);
            return;
        }
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        if (n == 0)
        {
            return 0;
        }

        tem = new ArrayList<Integer>();
        dp = new int[n];

        

        Set<Integer> kk = new TreeSet<Integer>();
        kk.add(nums[0]);

        dp[0] = 1;
        tem.add(0);
        for (int i = 1; i < n; ++i)
        {
            for (int k: tem)
            {
                if (nums[i] > nums[k])
                {
                    dp[i] = dp[k] + 1;
                    break;
                }
            }
            dp[i] = dp[i] > 1 ? dp[i] : 1;
            add(i);
        }
        return dp[tem.get(0)];
    }
    public static void main(String[] args)
    {
        int[] nums = {2,15,3,7,8,6,18};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
