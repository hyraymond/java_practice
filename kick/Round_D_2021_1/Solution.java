package Round_D_2021_1;

import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            long[][] mat;
            long temp = 0;
            long result = 0;
            int case_number = Integer.parseInt(bf.readLine());
            Map<Integer, Integer> table;
            for (int k = 0; k < case_number; ++k)
            {
                temp = 0;
                table = new TreeMap<Integer, Integer>();
                result = 0;
                String[] str = bf.readLine().split(" ");
                mat = new int[3][3];
                mat[0][0] = Integer.parseInt(str[0]);
                mat[0][1] = Integer.parseInt(str[1]);
                mat[0][2] = Integer.parseInt(str[2]);
                str = bf.readLine().split(" ");
                mat[1][0] = Integer.parseInt(str[0]);
                mat[1][2] = Integer.parseInt(str[1]);
                str = bf.readLine().split(" ");
                mat[2][0] = Integer.parseInt(str[0]);
                mat[2][1] = Integer.parseInt(str[1]);
                mat[2][2] = Integer.parseInt(str[2]);
                if (mat[0][0] + mat[0][2] == 2*mat[0][1])
                {
                    ++temp;
                }
                if (mat[2][0] + mat[2][2] == 2*mat[2][1])
                {
                    ++temp;
                }
                if (mat[0][0] + mat[2][0] == 2*mat[1][0])
                {
                    ++temp;
                }
                if (mat[0][2] + mat[2][2] == 2*mat[1][2])
                {
                    ++temp;
                }

                if ((mat[1][0] + mat[1][2])%2 == 0)
                {
                    int te = (mat[1][0] + mat[1][2])/2;
                    if (table.containsKey(te) == false)
                    {
                        table.put(te, 1);
                        result = result < 1? 1: result;
                    }
                    else
                    {
                        int tet = table.get(te);
                        table.put(te, tet+1);
                        result = result < te+1? tet+1: result;
                    }
                }
                if ((mat[0][1] + mat[2][1])%2 == 0)
                {
                    int te = (mat[0][1] + mat[2][1])/2;
                    if (table.containsKey(te) == false)
                    {
                        table.put(te, 1);
                        result = result < 1? 1: result;
                    }
                    else
                    {
                        int tet = table.get(te);
                        table.put(te, tet+1);
                        result = result < te+1? tet+1: result;
                    }
                }
                if ((mat[0][0] + mat[2][2])%2 == 0)
                {
                    int te = (mat[0][0] + mat[2][2])/2;
                    if (table.containsKey(te) == false)
                    {
                        table.put(te, 1);
                        result = result < 1? 1: result;
                    }
                    else
                    {
                        int tet = table.get(te);
                        table.put(te, tet+1);
                        result = result < te+1? tet+1: result;
                    }
                }
                if ((mat[0][2] + mat[2][0])%2 == 0)
                {
                    int te = (mat[0][2] + mat[2][0])/2;
                    if (table.containsKey(te) == false)
                    {
                        table.put(te, 1);
                        result = result < 1? 1: result;
                    }
                    else
                    {
                        int tet = table.get(te);
                        table.put(te, tet+1);
                        result = result < te+1? tet+1: result;
                    }
                }
                temp += result;

                System.out.print("Case #"+(k+1)+": " + temp);
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