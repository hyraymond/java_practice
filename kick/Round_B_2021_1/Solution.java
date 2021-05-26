package Round_B_2021_1;
import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                int str_len = Integer.parseInt(bf.readLine());
                String pattern = bf.readLine();
                int[] dp = new int[str_len];
                dp[0] = 1;
                
                System.out.print("Case #"+(k+1)+": " + dp[0] + " ");
                for(int i = 1; i < str_len; ++i)
                {
                    if (pattern.charAt(i) > pattern.charAt(i - 1))
                    {
                        dp[i] = dp[i - 1] + 1;
                    }
                    else
                    {
                        dp[i] = 1;
                    }
                    System.out.print(dp[i] + " ");
                }
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
