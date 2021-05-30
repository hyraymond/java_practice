package Round_B_2021_2;
// Fidn the Longest Progression with at most one posistion change, reference: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435a5b/000000000077a3a5#analysis
// Solution1: dp, only pass the sample set.
// Solution2: divide and conquer, back and forth, pass all test sets. 
import java.util.*;
import java.io.*;
// class dp_node
// {
//     int val;
//     int after_val;
//     int change_index;
//     int change_val;
// }

class chunk
{
    int d;
    int start_index;
    int length;
}

public class Solution{
    // Solution1
    // private static dp_node[] dp;
    // private static void dp_init(int[] ray, int n)
    // {
    //     dp = new dp_node[n];
    //     for(int i = 0; i < n; ++i)
    //     {
    //         dp[i] = new dp_node();
    //         dp[i].val = -1;
    //         dp[i].after_val = -1;
    //         dp[i].change_index = -1;
    //     }
    //     dp[0].val = 1;
    //     dp[0].after_val = 1;
    //     dp[1].val = 2;
    //     dp[1].after_val = 2;
    // }
    // private static dp_node dp_run(int[] ray, int n, int index)
    // {
    //     if (dp[index].val == -1)
    //     {
    //         if (ray[index] - ray[index-1] == ray[index - 1] - ray[index - 2])
    //         {
    //             dp[index].val = dp_run(ray, n, index - 1).val + 1;
    //             if (dp_run(ray, n, index - 1).change_index == -1)
    //             {
    //                 dp[index].change_index = -1;
    //                 dp[index].after_val = dp[index - 1].after_val;
    //             }
    //             else
    //             {
    //                 int temp = ray[dp_run(ray, n, index - 1).change_index];
    //                 ray[dp_run(ray, n, index - 1).change_index] = dp_run(ray, n, index - 1).change_val;
    //                 if (ray[index] - ray[index-1] == ray[index - 1] - ray[index - 2])
    //                 {
    //                     dp[index].change_index = dp_run(ray, n, index - 1).change_index;
    //                     dp[index].change_val = dp_run(ray, n, index - 1).change_val;
    //                     dp[index].after_val = dp_run(ray, n, index - 1).after_val + 1;
    //                 }
    //                 else
    //                 {
    //                     dp[index].change_index = index;
    //                     dp[index].change_val = 2 * ray[index - 1] - ray[index - 2];
    //                     dp[index].after_val = 3;
    //                 }
    //                 ray[dp_run(ray, n, index - 1).change_index] = temp;
    //             }
    //         }
    //         else
    //         {
    //             dp[index].val = 2;
    //             if (dp_run(ray, n, index - 1).change_index == -1)
    //             {
    //                 dp[index].change_index = index;
    //                 dp[index].change_val = 2 * ray[index - 1] - ray[index - 2];
    //                 dp[index].after_val = dp_run(ray, n, index - 1).val + 1;
    //             }
    //             else
    //             {
    //                 int temp = ray[dp_run(ray, n, index - 1).change_index];
    //                 ray[dp_run(ray, n, index - 1).change_index] = dp_run(ray, n, index - 1).change_val;
    //                 if (ray[index] - ray[index-1] == ray[index - 1] - ray[index - 2])
    //                 {
    //                     dp[index].change_index = dp_run(ray, n, index - 1).change_index;
    //                     dp[index].change_val = dp_run(ray, n, index - 1).change_val;
    //                     dp[index].after_val = dp_run(ray, n, index - 1).after_val + 1;
    //                 }
    //                 else
    //                 {
    //                     dp[index].change_index = index;
    //                     dp[index].change_val = 2 * ray[index - 1] - ray[index - 2];
    //                     dp[index].after_val = 3;
    //                 }
    //                 ray[dp_run(ray, n, index - 1).change_index] = temp;
    //             }
    //         }
    //     }
    //     return dp[index];
    // }
    // private static int search(int n)
    // {
    //     int best = 0;
    //     for(int i = 0; i < n; ++i)
    //     {
    //         int temp = dp[i].val > dp[i].after_val? dp[i].val : dp[i].after_val;
    //         best = temp > best? temp: best;
    //     }
    //     return best;
    // }

    // Solution2
    static int[] AtoD(int[] ray)
    {
        int n = ray.length;
        int key = ray[1] - ray[0];

        int[] result = new int[n - 1];
        for(int i = 1; i < n; ++i)
        {
            result[i - 1] = ray[i] - ray[i-1];
            if (result[i - 1] != key)
            {
                key = result[i - 1];
            }
        }

        return result;
    }
    static int func(int[] ray)
    {
        int n = ray.length;
        if (n <= 3)
        {
            return n - 1;
        }

        int[] D = AtoD(ray);
        List<chunk> C = new ArrayList<chunk>();
        chunk temp;
        temp = new chunk();

        for (int i = 0; i < D.length; ++i)
        {
            if (i == 0)
            {
                temp.start_index = 0;
                temp.d = D[0];
            }
            else if (D[i] == temp.d)
            {
                continue;
            }
            else
            {
                temp.length = i - temp.start_index;
                C.add(temp);
                temp = new chunk();
                temp.start_index = i;
                temp.d = D[i];
            }
        }
        temp.length = D.length - temp.start_index;
        C.add(temp);

        n = C.size();
        int best = 0;
        int l = 0;

        for(int i = 0; i < n - 1; ++i)
        {
            chunk k = C.get(i);
            int d = k.d;
            l = k.length;
            chunk next = C.get(i + 1);
            int nd = D[k.start_index + k.length];
            int nnd = k.start_index + k.length + 1 < D.length? D[k.start_index + k.length + 1]: Integer.MAX_VALUE;
            int nnnd = k.start_index + k.length + 2 < D.length? D[k.start_index + k.length + 2]: Integer.MAX_VALUE;
            if (nnd == Integer.MAX_VALUE)
            {
                l += 1;
            }
            else if (nd + nnd == 2 * d)
            {
                if(nnnd == Integer.MAX_VALUE || nnnd != d)
                {
                    l += 2;
                }
                else if (nnnd == d)
                {
                    l += (2 + C.get(i  + 3).length);
                }
            }
            else
            {
                l += next.length;
            }
            best = l > best? l: best;
        }
        best = temp.length > best? temp.length: best;
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
                int []rray = new int[n];
                String[]mip = bf.readLine().split(" ");

                for (int i = 0; i < n; ++i)
                {
                    ray[i] = Integer.parseInt(mip[i]);
                    rray[n - i - 1] = ray[i];
                }
                int out1 = func(ray);
                int out2 = func(rray);
                int out = out1 > out2? out1: out2;
                System.out.print("Case #"+(k+1)+": " + (out + 1));
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