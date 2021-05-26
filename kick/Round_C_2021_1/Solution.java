package Round_C_2021_1;
// Smaller String, reference: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435c44/00000000007ebe5e
// Use StringBuffer, reference: https://www.runoob.com/java/java-stringbuffer.html
// Solution1, brute force, only pass the set one.
// Solution2, calculate the possible mutation.
import java.util.*;
import java.io.*;

import java.io.*;
public class Solution{
    private static long mo = (long)Math.pow(10, 9) + 7;
    /* Solution 1:
    private static int val = 0;
    private static void ss(StringBuffer mutation, String pattern, int index, int str_len, int pace)
    {
        int len = str_len/2;
        if (str_len == 0)
        {
            return;
        }
        if ((index > len) || (index == len && str_len%2 == 0) )
        {
            ++val;
            return;
        }

        for (int i = 97; i < 97 + pace; ++i)
        {
            mutation.setCharAt(index, (char)i);
            mutation.setCharAt(str_len - index - 1, (char)i);
            if (check(pattern, mutation, index) == false)
            {
                return;
            }
            ss(mutation, pattern, index + 1, str_len, pace);
            mutation.setCharAt(index, 'a');
            mutation.setCharAt(str_len - index - 1, 'a');
        }
    }
    private static boolean check(String pattern, StringBuffer mutation, int index)
    {
        for (int i  = 0; i < pattern.length(); ++i)
        {
            if (pattern.charAt(i) < mutation.charAt(i))
            {
                return false;
            }
            else if (pattern.charAt(i) > mutation.charAt(i))
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                val = 0;
                String[] temp = bf.readLine().split(" ");
                int str_len = Integer.parseInt(temp[0]);
                int pace = Integer.parseInt(temp[1]);
                String pattern = bf.readLine();
                StringBuffer mutation = new StringBuffer("");

                for(int i = 0; i < str_len; ++i)
                {
                    mutation.append('a');
                }

                ss(mutation, pattern, 0, str_len, pace);
                System.out.print("Case #"+(k+1)+": " + val);
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
    */

    // Solution two
    private static boolean check(String pattern, String mutation)
    {
        for (int i  = 0; i < pattern.length(); ++i)
        {
            if (pattern.charAt(i) < mutation.charAt(i))
            {
                return false;
            }
            else if (pattern.charAt(i) > mutation.charAt(i))
            {
                return true;
            }
        }
        return false;
    }
    private static long ss(String pattern, int index, int str_len, int pace)
    {
        int len = (str_len + 1) / 2;
        if (str_len == 0)
        {
            return 0;
        }
        if (index >= len)
        {
            String tes = pattern.substring(0, len);
            StringBuilder puf = new StringBuilder(tes).reverse();
            if (str_len % 2 == 0)
            {
                tes = tes + puf.toString();
            }
            else
            {
                tes = tes + puf.substring(1, len);
            }

            if (check(pattern, tes) == false)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }

        int n1 = (int)(pattern.charAt(index) - 'a');
        int n2 = pace - 1;
        int p = n1 < n2 ? n1 : n2;
        int sig = len - index - 1;
        long k = (long)(Math.pow(pace, sig));
        
        return (p * k + ss(pattern, index + 1, str_len, pace))%mo;
        
    }
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                String[] temp = bf.readLine().split(" ");
                int str_len = Integer.parseInt(temp[0]);
                int pace = Integer.parseInt(temp[1]);
                String pattern = bf.readLine();
                long kkk =ss(pattern, 0, str_len, pace);
                System.out.print("Case #"+(k+1)+": " + kkk + "\n");
                // TBD
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }
}