package Round_A_2016_2;

// Rain
import java.util.*;
import java.io.*;
class pos implements Comparable{
    int x;
    int y;
    int val;
    pos()
    {
        x = 0;
        y = 0;
        val = 0;
    }
    pos(int a, int b, int c)
    {
        x = a;
        y = b;
        val = c;
    }
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        return val - ((pos)o).val;
    }
}
public class Solution{
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            PriorityQueue<pos> q;
            for (int k = 0; k < case_number; ++k)
            {
                String[] num = bf.readLine().split(" ");
                int row = Integer.parseInt(num[0]);
                int col = Integer.parseInt(num[1]);
                int temp = 0;
                q = new PriorityQueue<pos>();
                int[][] table = new int[row][col];
                int[][] visit = new int[row][col];
                for (int i = 0; i < row; ++i)
                {
                    String[] str = bf.readLine().split(" ");
                    for (int j = 0; j < col; ++j)
                    {
                        table[i][j] = Integer.parseInt(str[j]);
                    }
                }
                if (row >= 3 && col >= 3)
                {
                    for (int i : new int[] {0, row-1})
                    {
                        for (int j = 0; j < col; ++j)
                        {
                            q.add(new pos(i, j, table[i][j]));
                            visit[i][j] = 1;
                        }
                    }
                    for (int i : new int[] {0, col-1})
                    {
                        for (int j = 1; j < row - 1; ++j)
                        {
                            q.add(new pos (j, i, table[j][i]));
                            visit[j][i] = 1;
                        }
                    }
                }
                while(q.isEmpty() == false)
                {
                    pos min = q.peek();
                    q.poll();
                    if (min.x > 0 && visit[min.x-1][min.y] == 0)
                    {
                        if (table[min.x-1][min.y] < min.val)
                        {
                            temp += (min.val - table[min.x-1][min.y]);
                            table[min.x-1][min.y] = min.val;
                            q.add(new pos(min.x - 1, min.y, min.val));
                        }
                        else
                        {
                            q.add(new pos(min.x - 1, min.y, table[min.x-1][min.y]));
                        }
                        visit[min.x-1][min.y] = 1;
                    }
                    if (min.x < row - 1 && visit[min.x+1][min.y] == 0)
                    {
                        if (table[min.x+1][min.y] < min.val)
                        {
                            temp += (min.val - table[min.x+1][min.y]);
                            table[min.x+1][min.y] = min.val;
                            q.add(new pos(min.x + 1, min.y, min.val));
                        }
                        else
                        {
                            q.add(new pos(min.x + 1, min.y, table[min.x+1][min.y]));
                        }
                        visit[min.x+1][min.y] = 1;
                    }
                    if (min.y > 0 && visit[min.x][min.y-1] == 0)
                    {
                        if (table[min.x][min.y-1] < min.val)
                        {
                            temp += (min.val - table[min.x][min.y-1]);
                            table[min.x][min.y-1] = min.val;
                            q.add(new pos(min.x, min.y-1, min.val));
                        }
                        else
                        {
                            q.add(new pos(min.x, min.y - 1, table[min.x][min.y-1]));
                        }
                        visit[min.x][min.y-1] = 1;
                    }
                    if (min.y < col - 1 && visit[min.x][min.y + 1] == 0)
                    {
                        if (table[min.x][min.y + 1] < min.val)
                        {
                            temp += (min.val - table[min.x][min.y + 1]);
                            table[min.x][min.y+1] = min.val;
                            q.add(new pos(min.x, min.y+1, min.val));
                        }
                        else
                        {
                            q.add(new pos(min.x, min.y+1, table[min.x][min.y+1]));
                        }
                        visit[min.x][min.y+1] = 1;
                    }

                }
                System.out.print("Case #"+(k+1)+": " + temp);
                System.out.println("");
                // for (int i = 0; i < row; ++i)
                // {
                //     for (int j = 0; j < col; ++j)
                //     {
                //         System.out.print(table[i][j] + " ");
                //     }
                //     System.out.println();
                // }
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
