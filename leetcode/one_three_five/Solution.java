package one_three_five;

import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        int result = n;
        PriorityQueue<Integer> tem = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return ratings[o1] - ratings[o2];
            }
        });
        for (int i = 0; i < n; ++i)
        {
            dp[i] = 1;
            tem.offer(i);
        }

        while(!tem.isEmpty())
        {
            int cur = tem.peek().intValue();
            int temp = dp[cur];
            int a = cur > 0 ? ratings[cur - 1]: Integer.MAX_VALUE;
            int b = cur < n - 1? ratings[cur + 1]: Integer.MAX_VALUE;
            if (ratings[cur] > a)
            {
                if (cur > 0)
                {
                    temp = Math.max(temp, dp[cur - 1] + 1);
                }
            }
            if (ratings[cur] > b)
            {
                
                if (cur < n -1)
                {
                    temp = Math.max(temp, dp[cur + 1] + 1);
                }
            }
            result = result + (temp - dp[cur]);
            dp[cur] = temp;
            tem.poll();
        }
        return result;
    }
}