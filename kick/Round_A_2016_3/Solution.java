package Round_A_2016_3;

import java.util.*;
import java.io.*;
// quick power algorithm

public class Solution{
    private static double quick_pow(double i, int n )
    {
        double res = 1.0;
        double b = i;
        while(n > 0)
        {
            if ((n & 1) == 1)
            {
                res *= b;
            }
            b *= b;
            n = n >> 1;
        }
        return res;
    }
    public static double fx(double[] month, double i)
    {
        int n = month.length;
        double te = quick_pow(i, n-1);
        double temp = te;
        double result = -month[0] * temp;
        for (int c = 1; c < month.length; ++c)
        {
            temp = quick_pow(i, n - c - 1);
            result += temp * month[c];
        }
        return result;
    }
    public static double fdx(double[] month, double i)
    {
        int n = month.length;
        double te = quick_pow(i, n-2);
        double temp = te;
        double result = -month[0] * temp * (n - 1);
        for (int c = 1; c < month.length; ++c)
        {
            temp = quick_pow(i, n-c-2);
            result += temp * month[c] * (n - c - 1);
        }
        return result;
    }
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                int month_num = Integer.parseInt(bf.readLine());
                double[] month = new double[month_num + 1];
                String[] str = bf.readLine().split(" ");
                for (int i = 0; i <= month_num; ++i)
                {
                    month[i] = Double.parseDouble(str[i]);
                }
                double jie = 2.0;
                while(true)
                {
                    double temp = fx(month, jie);
                    double te;
                    if (Math.abs(temp - 0) <= Math.pow(0.1, 12))
                    {
                        break;
                    }
                    else
                    {
                        te = fdx(month, jie);
                        jie = jie - (temp/te);
                    }
                    // System.out.println(temp + " " + jie + " " + te);
                }
                System.out.print("Case #"+(k+1)+": " + (jie-1));
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

