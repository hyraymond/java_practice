package Round_C_2021_3;
// Rock, Paper, Scissors, reference: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435c44/00000000007ec28e.
// Use JAVA random number generator. Reference: https://www.cnblogs.com/blogxjc/p/9687297.html.
// Initialize HashMap by using anonymous class. Reference: https://blog.csdn.net/qq_22167989/article/details/90721822.
// Use enum class. Reference: https://www.cnblogs.com/panchanggui/p/10318368.html.
// Strategy One: Random Generate till the sequence satisfies the requirement.
// Strategy Two: Greedy Algorithm, Rock, Scissors and Paper Cycle.
// Strategy Three: Dynamic Processing.
import java.util.*;
import java.io.*;
enum STRATEGY
{
    ROCK, PAPER, SCISSORS;
};
public class Solution{
    private static int rounds = 60;
    private static int choice = 3;
    private static int[] strategy = {0, 2};
    public static void main(String[] args){
        try
        {
            // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            // //BufferedWriter wf = new BufferedWriter(new FileWriter("record.txt"));
            // int case_number = Integer.parseInt(bf.readLine());
            // int reward = Integer.parseInt(bf.readLine());
            // Random ran = new Random();
            // int w_reward;
            // int e_reward;
            // int[] record = new int[choice];

            // Arrays.fill(record, 0);
            // for (int k = 0; k < case_number; ++k)
            // {
            //     String[] reward_set = bf.readLine().split(" ");
            //     w_reward = Integer.parseInt(reward_set[0]);
            //     e_reward = Integer.parseInt(reward_set[1]);
            //     double temp_result = 0 ;
            //     do
            //     {
            //         temp_result = 0;
            //         strategy = new int[rounds];

            //         for (int i = 0; i < rounds; ++i)
            //         {
            //             strategy[i] = ran.nextInt(choice);
            //             temp_result += reward_calculate(i, w_reward, e_reward, record);
            //             record[strategy[i]]++;
            //         }
            //     }while(temp_result < reward);

            //     //wf.write("Case #"+(k+1)+": " + temp_result + " ");
            //     System.out.print("Case #"+(k+1)+": ");
            //     for(int i = 0; i < strategy.length; ++i)
            //     {
            //         switch(strategy[i])
            //         {
            //             case(0):
            //             {
            //                 //wf.write("R");
            //                 System.out.print("R");
            //                 break;
            //             }
            //             case(1):
            //             {
            //                 //wf.write("P");
            //                 System.out.print("P");
            //                 break;
            //             }
            //             default:
            //             {
            //                 //wf.write("S");
            //                 System.out.print("S");
            //                 break;
            //             }
            //         }
            //     }
            //     //wf.write("\n");
            //     System.out.println(" ");
            //     //wf.flush();
            // }
            // //wf.close();
            String pip = "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR";
            int[] pop = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            int[] reco = {59, 0, 0};
            System.out.println(reward_calculate(59, 100, 0, reco, pop));
        }
        catch(Exception e)
        {
            return;
        }
    }
    private static double reward_calculate(int rounds, int w_reward, int e_reward, int[] record, int[] stra)
    {
        double temp_result = 0;

        if (rounds == 0)
        {
            temp_result += (double)w_reward/3 + (double)e_reward/3;
        }
        else
        {
            temp_result += ((double)(record[(stra[rounds]+1)%3]) * (double)w_reward + (double)(record[(stra[rounds]+2)%3]) * (double)e_reward)/(double)rounds ;
        }

        return temp_result;
    }
    private static int[] stringToInt(String stra)
    {
        int n = stra.length();
        int[] tactic = new int[n];
        for(int i = 0; i < n; ++i)
        {
            switch(stra.charAt(i))
            {
                case('R'):
                {
                    tactic[i] = 0;
                    break;
                }
                case('P'):
                {
                    tactic[i] = 1;
                    break;
                }
                default:
                {
                    tactic[i] = 2;
                    break;
                }
            }
        }
        return tactic;
    }
    private static void printStrategy(int[] tactic)
    {
        for(int i = 0; i < tactic.length; ++i)
        {
            switch(tactic[i])
            {
                case(0):
                {
                    System.out.print("R");
                    break;
                }
                case(1):
                {
                    System.out.print("P");
                    break;
                }
                default:
                {
                    System.out.print("S");
                    break;
                }
            }
        }
    }
}
