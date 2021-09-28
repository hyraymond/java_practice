package Q2;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int len = in.nextInt();
            for (int i = 0; i < len; ++i)
            {
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int j = 0; j < n; ++j)
                {
                    arr[j] = in.nextInt();
                }

                for (int j = 0; j < n; ++j)
                {
                    int min_index = j;
                    int min_val = arr[j];
                    int d = 0;
                    int[] next_arr = new int[n];
                    for (int k = j+1; k < n; ++k)
                    {
                        if (arr[k] < arr[j])
                        {
                            min_index = k;
                            min_val = arr[k];
                        }
                    }

                    d = min_index - j;
                    for (int k = j; k <= min_index; ++k)
                    {
                        next_arr[k] = arr[(k + d)%n];
                    }
                    for (int k = j; k <= min_index; ++k)
                    {
                        arr[k] = next_arr[k];
                    }
                    if (d > 0)
                    {
                        System.out.println((j+1) + " " + (min_index+1) + " " + d);
                    }
                }
            }
        }
    }
}
