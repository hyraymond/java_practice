package Round_A_2016_1;

// Country Leader
import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        try
        {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int case_number = Integer.parseInt(bf.readLine());
            for (int k = 0; k < case_number; ++k)
            {
                int name_number = Integer.parseInt(bf.readLine());
                String[] names = new String[name_number];
                Set<Character> re;
                int index = 0;
                int max = 0;
                for (int i = 0; i < name_number; ++i)
                {
                    re = new HashSet<Character>();
                    names[i] = bf.readLine();
                    for (int j = 0; j < names[i].length(); ++j)
                    {
                        if (Character.isAlphabetic(names[i].charAt(j)))
                        {
                            re.add(names[i].charAt(j));
                        }
                    }
                    int temp = re.size();
                    if (temp > max)
                    {
                        index = i;
                        max = temp;
                    }
                    else if (temp == max)
                    {
                        if (names[i].compareTo(names[index]) < 0)
                        {
                            index = i;
                            max = temp;
                        }
                    }
                }
                System.out.print("Case #"+(k+1)+": " + names[index]);
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
