package Round_H_2019_1;
//H-index, Round H 2019, problem1, reference shown as https://codingcompetitions.withgoogle.com/kickstart/round/0000000000050edd/00000000001a274e#problem
//Sample Test: 2 3 5 1 2 6 1 3 3 2 2 15
import java.io.*;
import java.util.*;
//Solution1, Self Build. Pass data set one, but failed data set two due to time limit exceeded.
// public class Solution{
//     public static void main(String[] args){
//         Scanner in = new Scanner(System.in);
//         String case_num = in.next();
//         int case_number = Integer.parseInt(case_num);
//         for (int k = 0; k < case_number; ++k)
//         {
//             String temp = in.next();
//             int n = Integer.parseInt(temp);
//             int[] score = new int[n];
//             int temp_value = 0;
//             int score_max = 0;

//             for (int i = 0; i < n; ++i)
//             {
//                 temp = in.next();
//                 temp_value = Integer.parseInt(temp);

//                 if (i == 0)
//                 {
//                     System.out.print("Case #"+(k+1)+": ");
//                 }

//                 for (int j = 0; j < n; ++j)
//                 {
//                     if (temp_value >= j + 1)
//                     {
//                         ++score[j];
//                         if (score[j] >= j + 1 && j + 1 > score_max)
//                         {
//                             score_max = j + 1;
//                         }
//                     }
//                 }
//                 System.out.print(score_max+" ");
//             }
//             System.out.println(" ");
//         }
//     }
// }
//Solution2, use a prioriry queue. Pass all two sets. O(nlogn)
public class Solution{
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                int n = Integer.parseInt(bf.readLine());
                PriorityQueue<Integer> result = new PriorityQueue<Integer>();
                String[] data_array = bf.readLine().split(" ");

                System.out.print("Case #"+(k+1)+":");
                for (int i = 0; i < n; ++i)
                {
                    int temp_value = Integer.parseInt(data_array[i]);

                    if (temp_value >= result.size())
                    {
                        result.add(temp_value);
                    }
                    while (result.peek() < result.size())
                    {
                        result.poll();
                    }
                    System.out.print(" "+ result.size());
                }
                System.out.println(" ");
            }
        }
        catch(Exception e)
        {
            return;
        }
    }
}