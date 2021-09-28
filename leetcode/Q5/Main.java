package Q5;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            for (int i = 0; i < n; ++i)
            {
                int len = in.nextInt();
                int[] arr = new int[len];
                int result = 0;
                LinkedList<Integer> con = new LinkedList<Integer>();
                for (int j = 0; j < len; ++j)
                {
                    arr[j] = in.nextInt();
                    if (con.isEmpty())
                    {
                        con.addFirst(arr[j]);
                    }
                    else
                    {
                        int min_num = 0;
                        int max_num = 0;
                        for (Integer p: con)
                        {
                            if (arr[j] > p)
                            {
                                min_num++;
                            }
                            else if (arr[j] < p)
                            {
                                max_num++;
                            }
                        }
                        if (min_num > max_num)
                        {
                            con.addLast(arr[j]);
                            result += max_num;
                        }
                        else 
                        {
                            con.addFirst(arr[j]);
                            result += min_num;
                        }
                    }
                }
                System.out.println(result);
            }
        }
    }
}
