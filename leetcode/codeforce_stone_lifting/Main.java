package codeforce_stone_lifting;
import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int key = in.nextInt();
            int result = 0;
            while (key > 0)
            {
                int temp = key&1;
                if (temp == 1)
                {
                    ++result;
                }
                key = key >> 1;
            }
            System.out.println(result);
        }
    }
}