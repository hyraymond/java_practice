package Round_C_2021_3;
// Rock, Paper, Scissors, reference: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435c44/00000000007ec28e.
// Use JAVA random number generator. Reference: https://www.cnblogs.com/blogxjc/p/9687297.html.
// Initialize HashMap by using anonymous class. Reference: https://blog.csdn.net/qq_22167989/article/details/90721822.
// Use enum class. Reference: https://www.cnblogs.com/panchanggui/p/10318368.html.
// Strategy One: Greedy Algorithm, Rock, Scissors and Paper Cycle.
// Strategy Two: Random Generate till the sequence satisfies the requirement.
// Strategy Three: Dynamic Processing.
import java.util.*;
import java.io.*;
class DP_NODE
{
    double val;
    char prev;
}
public class Solution{
    private static final int rounds = 60;
    private static double w_reward;
    private static double e_reward;
    private static DP_NODE[][][] dp;

    private static double DP(int r, int p, int s)
    {
        double bonus1 = 0, bonus2 = 0, bonus3 = 0;
        double t = r + p + s -1;
        if (dp[r][p][s].val < 0)
        {
            if (r != 0)
            {
                bonus1 = DP(r - 1, p, s) + (w_reward * p) / t + (e_reward * s) / t;
            }
            if (s != 0)
            {
                bonus3 = DP(r, p, s - 1) + (w_reward * r) / t + (e_reward * p) / t;
            }
            if (p != 0)
            {
                bonus2 = DP(r, p - 1, s) + (w_reward * s) / t + (e_reward * r) / t;
            }

            if (bonus1 > bonus2 && bonus1 > bonus3)
            {
                dp[r][p][s].val = bonus1;
                dp[r][p][s].prev = 'R';
            }
            else if (bonus3 > bonus2)
            {
                dp[r][p][s].val = bonus3;
                dp[r][p][s].prev = 'S';
            }
            else
            {
                dp[r][p][s].val = bonus2;
                dp[r][p][s].prev = 'P';
            }
        }
        return dp[r][p][s].val;
    }

    private static void DP_INIT()
    {
        dp = new DP_NODE[rounds + 1][rounds + 1][rounds + 1];
        for (int i = 0; i <=rounds; ++i)
        {
            dp[i] = new DP_NODE[rounds + 1][rounds + 1];
            for (int j = 0; j <=rounds; ++j)
            {
                dp[i][j] = new DP_NODE[rounds + 1];
                for (int l = 0; l <=rounds; ++l)
                {
                    dp[i][j][l] = new DP_NODE();
                    dp[i][j][l].val = -1;
                }
            }
        }
        dp[1][0][0].val = w_reward/3 + e_reward/3;
        dp[1][0][0].prev = 'R';
        dp[0][1][0].val = w_reward/3 + e_reward/3;
        dp[0][1][0].prev = 'P';
        dp[0][0][1].val = w_reward/3 + e_reward/3;
        dp[0][0][1].prev = 'S';
    }

    private static void search(int[] index)
    {
        double best = -1;
        for (int i = 0; i <= rounds; ++i)
        {
            for (int l = 0; l < rounds - i; ++l)
            {
                int j = 60 - i - l;
                double res = DP(i, j, l);
                if (res > best)
                {
                    best = res;
                    index[0] = i;
                    index[1] = j;
                    index[2] = l;
                    //System.out.println(i + " " + j + " " + l + " " + res);
                }
            }
        }
    }

    private static char[] trace(int[] index)
    {
        char[] result = new char[rounds + 1];
        for (int i = rounds - 1; i >= 0; --i)
        {
            result[i] = dp[index[0]][index[1]][index[2]].prev;
            switch(result[i])
            {
                case('R'):
                {
                    --index[0];
                    break;
                }
                case('P'):
                {
                    --index[1];
                    break;
                }
                default:
                {
                    --index[2];
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            //BufferedWriter wf = new BufferedWriter(new FileWriter("record.txt"));
            int case_number = Integer.parseInt(bf.readLine());
            int reward = Integer.parseInt(bf.readLine());
            int[] index = new int[3];

            for (int k = 0; k < case_number; ++k)
            {
                String[] reward_set = bf.readLine().split(" ");
                w_reward = Double.parseDouble(reward_set[0]);
                e_reward = Double.parseDouble(reward_set[1]);
                System.out.print("Case #"+ (k+1) + ": ");
                DP_INIT();
                search(index);
                char[] res = trace(index);
                for (char p: res)
                {
                    System.out.print(p);
                }
                System.out.println("");
            }
        }
        catch(Exception e)
        {
            return;
        }
    }
}
