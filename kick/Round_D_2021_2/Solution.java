package Round_D_2021_2;

import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            long[] exam_s;
            long[] exam_e;
            long[] skill;
            TreeSet<Integer> start;
            TreeSet<Integer> end;
            for (int k = 0; k < case_number; ++k)
            {
                String[] str = bf.readLine().split(" ");
                int n = Integer.parseInt(str[0]);
                int c = Integer.parseInt(str[1]);
                start = new TreeSet<Integer>();
                end = new TreeSet<Integer>();
                exam_s = new long[n];
                exam_e = new long[n];
                for (int i = 0; i < n; ++i)
                {
                    str = bf.readLine().split(" ");
                    exam_s[i] = Integer.parseInt(str[0]);
                    exam_e[i] = Integer.parseInt(str[1]);
                }
                skill = new long[c];
                str = bf.readLine().split(" ");
                for (int i = 0; i < c; ++i)
                {
                    skill[i] = Integer.parseInt(str[i]);
                }

                System.out.print("Case #"+(k+1)+": ");
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
    public int leftBSearch(int b, int e, int target, int[] arr)
    {
        int n = arr.length;
        if (b < 0 || b > n - 1 || e < 0 || e > n -1)
        {
            return -1;
        }

        if (b >= e)
        {
            return b;
        }

        int mid = (b + e) / 2;
        int temp = arr[mid];
        if (temp > target)
        {
            return leftBSearch(b, mid, target, arr);
        }
        else if(temp < target)
        {
            return leftBSearch(mid + 1, e, target, arr);
        }
        else 
        {
            return leftBSearch(b, mid - 1, target, arr);
        }
    }
    public int rightBSearch(int b, int e, int target, int[] arr)
    {
        int n = arr.length;
        if (b < 0 || b > n - 1 || e < 0 || e > n -1)
        {
            return -1;
        }

        if (b >= e)
        {
            return e;
        }

        int mid = (b + e)/2;
        int temp = arr[mid];
        if (temp > target)
        {
            return rightBSearch(b, mid - 1, target, arr);
        }
        else if(temp < target)
        {
            return rightBSearch(mid, e, target, arr);
        }
        else
        {
            return rightBSearch(b + 1, e, target, arr);
        }
    }
}