package Q3;
import java.util.*;
public class Main {
    private static void check(char[][] board, int x, int y, int k, Map<Integer, Integer> con)
    {
        int i = 1;
        int ny = board[0].length;
        while(true)
        {
            int a_x = x - i;
            int a_y = y - i;
            int b_x = x - i;
            int b_y = y + i;
            if (a_x >= 0 && a_y >= 0 && b_y < board[0].length && board[a_x][a_y] == '*' && board[b_x][b_y] == '*')
            {
                ++i;
            }
            else
            {
                break;
            }
        }
        if (i > k)
        {
            for (int len = 0; len < i; ++len)
            {
                int tempa = (x-len) * ny + (y-len);
                int tempb = (x-len) * ny + (y+len);
                con.put(tempa, 1);
                con.put(tempb, 1);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            in.nextLine();
            for (int i = 0; i < n; ++i)
            {
                int xm = in.nextInt();
                int yn = in.nextInt();
                int k = in.nextInt();
                in.nextLine();
                char[][] table = new char[xm][yn];
                Map<Integer, Integer> con = new HashMap<Integer, Integer>();
                for (int j = 0; j < xm; ++j)
                {
                    String str = in.nextLine();
                    table[j] = str.toCharArray();
                    for (int p = 0; p < yn; ++p)
                    {
                        if (table[j][p] == '*')
                        {
                            con.put(j*yn+p, 0);
                        }
                    }
                }
                for (int j = 0; j < xm; ++j)
                {
                    for (int p = 0; p < yn; ++p)
                    {
                        if (table[j][p] == '*')
                        {
                            check(table, j, p, k, con);
                        }
                    }
                }
                int result = 1;
                for (Integer p: con.keySet())
                {
                    int a = con.get(p);
                    if (a == 0)
                    {
                        result = 0;
                        break;
                    }
                }
                if (result == 1)
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

