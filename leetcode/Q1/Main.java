package Q1;
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
                String key = in.next();
                int len = key.length();
                int[] count = new int[3];
                for (int j = 0; j < len; ++j)
                {
                    count[(int)(key.charAt(j) - 'A')]++;
                }
                if (count[0] + count[2] == count[1])
                {
                    System.out.println("YES");
                }
                else
                {
                    System.out.println("NO");
                }
            }
        }
    }
}
