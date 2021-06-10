package Round_H_2020_2;
// Boring Numbers, reference: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff49/000000000043b0c6
// Try to convert long to string, reference: https://zhidao.baidu.com/question/1930425739881321147.html
// Solution1: check the number one by one, failed in the data set 2.
import java.util.*;
import java.io.*;

// Solution1:
// public class Solution{
//     private static boolean checkBoringNumbers(long tes)
//     {
//         long temp = tes % 10;
//         long res = tes / 10;
//         int cur = temp % 2 == 0? 2: 1;
//         int last = cur;

//         while (res > 0)
//         {
//             temp = res % 10;
//             res = res / 10;
//             cur = temp % 2 == 0? 2: 1;
//             if (cur == last)
//             {
//                 return false;
//             }
//             last = cur;
//         }

//         if (cur == 1)
//         {
//             return true;
//         }
//         return false;
//     }
//     public static void main(String[] args){
//         try
//         {
//             BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//             int case_number = Integer.parseInt(bf.readLine());
//             for (int k = 0; k < case_number; ++k)
//             {
//                 String[] all = bf.readLine().split(" ");
//                 long lr = Integer.parseInt(all[0]);
//                 long rr = Integer.parseInt(all[1]);
//                 long num = 0;
//                 for(long i = lr; i <= rr; ++i)
//                 {
//                     if (true == checkBoringNumbers(i))
//                     {
//                         ++num;
//                     }
//                 }
//                 System.out.print("Case #"+(k+1)+": " + num);
//                 // TBD
//                 System.out.println("");
//             }
//         }
//         catch(Exception e)
//         {
//             System.out.println(e);
//             return;
//         }
//     }
// }

// Solution2
public class Solution{
    public static long value(long li)
    {
        if (li < 1)
        {
            return 0;
        }

        String temp = Long.toString(li);
        int n = temp.length();
        long num = 0;
        int t = 0;
        for(int i = 1; i < n; ++i)
        {
            num += Math.pow(5, i);
        }
        for(int i = 0; i < n; ++i)
        {
            t = (int)(temp.charAt(i) - '0');
            for (int index = 0; index < t; ++index)
            {
                if (index %2 - (i + 1) % 2 == 0)
                {
                    num += Math.pow(5, n - i - 1);
                }
            }
            if (i == n - 1)
            {
                if (t % 2 - (i + 1) % 2 == 0)
                {
                    ++num;
                }
            }
            if (t %2 - (i + 1) % 2 != 0)
            {
                break;
            }
        }
        
        return num;
    }
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                String[] all = bf.readLine().split(" ");
                long lr = Integer.parseInt(all[0]);
                long rr = Integer.parseInt(all[1]);
                long num = value(rr) - value(lr - 1); 
                System.out.print("Case #"+(k+1)+": " + num);
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
