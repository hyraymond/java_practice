package Round_B_2021_2;

import java.util.*;
import java.io.*;
class dp_node
{
    int val;
    int after_val;
    int change_index;
    int change_val;
}

public class Solution{
    private static dp_node[] dp;
    private static void dp_init(int[] ray, int n)
    {
        dp = new dp_node[n];
        for(int i = 0; i < n; ++i)
        {
            dp[i] = new dp_node();
            dp[i].val = -1;
            dp[i].after_val = -1;
            dp[i].change_index = -1;
        }
        dp[0].val = 1;
        dp[0].after_val = 1;
        dp[1].val = 2;
        dp[1].after_val = 2;
    }
    private static dp_node dp_run(int[] ray, int n, int index)
    {
        if (dp[index].val == -1)
        {
            if (ray[index] - ray[index-1] == ray[index - 1] - ray[index - 2])
            {
                dp[index].val = dp_run(ray, n, index - 1).val + 1;
                if (dp_run(ray, n, index - 1).change_index == -1)
                {
                    dp[index].change_index = -1;
                    dp[index].after_val = dp[index - 1].after_val;
                }
                else
                {
                    int temp = ray[dp_run(ray, n, index - 1).change_index];
                    ray[dp_run(ray, n, index - 1).change_index] = dp_run(ray, n, index - 1).change_val;
                    if (ray[index] - ray[index-1] == ray[index - 1] - ray[index - 2])
                    {
                        dp[index].change_index = dp_run(ray, n, index - 1).change_index;
                        dp[index].change_val = dp_run(ray, n, index - 1).change_val;
                        dp[index].after_val = dp_run(ray, n, index - 1).after_val + 1;
                    }
                    else
                    {
                        dp[index].change_index = index;
                        dp[index].change_val = 2 * ray[index - 1] - ray[index - 2];
                        dp[index].after_val = 3;
                    }
                    ray[dp_run(ray, n, index - 1).change_index] = temp;
                }
            }
            else
            {
                dp[index].val = 2;
                if (dp_run(ray, n, index - 1).change_index == -1)
                {
                    dp[index].change_index = index;
                    dp[index].change_val = 2 * ray[index - 1] - ray[index - 2];
                    dp[index].after_val = dp_run(ray, n, index - 1).val + 1;
                }
                else
                {
                    int temp = ray[dp_run(ray, n, index - 1).change_index];
                    ray[dp_run(ray, n, index - 1).change_index] = dp_run(ray, n, index - 1).change_val;
                    if (ray[index] - ray[index-1] == ray[index - 1] - ray[index - 2])
                    {
                        dp[index].change_index = dp_run(ray, n, index - 1).change_index;
                        dp[index].change_val = dp_run(ray, n, index - 1).change_val;
                        dp[index].after_val = dp_run(ray, n, index - 1).after_val + 1;
                    }
                    else
                    {
                        dp[index].change_index = index;
                        dp[index].change_val = 2 * ray[index - 1] - ray[index - 2];
                        dp[index].after_val = 3;
                    }
                    ray[dp_run(ray, n, index - 1).change_index] = temp;
                }
            }
        }
        return dp[index];
    }
    private static int search(int n)
    {
        int best = 0;
        for(int i = 0; i < n; ++i)
        {
            int temp = dp[i].val > dp[i].after_val? dp[i].val : dp[i].after_val;
            best = temp > best? temp: best;
        }
        return best;
    }
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                int n = Integer.parseInt(bf.readLine());
                int []ray = new int[n];
                String[]mip = bf.readLine().split(" ");

                for (int i = 0; i < n; ++i)
                {
                    ray[i] = Integer.parseInt(mip[i]);
                }
                dp_init(ray, n);
                dp_run(ray, n, n - 1);
                int result = search(n);
                System.out.print("Case #"+(k+1)+": " + result);
                // TBD
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }
}