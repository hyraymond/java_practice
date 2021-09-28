package Q6;
import java.util.*;
public class Main {
    private static int check(int[] arr, int d, int step)
    {
        int n = arr.length;
        int[] arr_next = new int[n];
        int sig = 0;
        int zero_num = 0;
        for (int i = 0; i < n; ++i)
        {
            int index = (i+n-d)%n;
            arr_next[i] = arr[index] & arr[i];
            if (arr_next[i] != arr[i])
            {
                sig = 1;
            }
            if (arr_next[i] == 0)
            {
                ++zero_num;
            }
        }
        for (int i = 0; i < n; ++i)
        {
            arr[i] = arr_next[i];
        }
        if (sig == 0)
        {
            if (zero_num == n)
            {
                return step-1;
            }
            else 
            {
                return -1;
            }
        }
        else
        {
            return check(arr, d, step+1);
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int num = in.nextInt();
            for (int i = 0; i < num; ++i)
            {
                int n = in.nextInt();
                int d = in.nextInt();
                int[] arr = new int[n];
                for (int j = 0; j < n; ++j)
                {
                    arr[j] = in.nextInt(); 
                }
                System.out.println(check(arr, d, 1));
            }
        }
    }
}
