import four.*;
import java.util.*;
public class tes {
    static int kkk(int[] k )
    {
        return k[0] = 3;
    }
    static List<Integer> find_prime_factor(int m)
    {
        if (m <= 1)
        {
            return null;
        }

        List<Integer> result = new ArrayList<Integer>();

        int i = 2;
        int x = m;
        while(i <= x)
        {
            if (x % i == 0)
            {
                while(x % i == 0)
                {
                    x /= i;
                }
                result.add(i);
            }
            ++i;
        }
        if (x > 1 || result.isEmpty())
        {
            result.add(x);
        }

        return result;
    }

    public static void main (String[] args) {
        int k = 420;
        List<Integer> result = find_prime_factor(k);
        for (int i = 0; i < result.size(); ++i)
        {
            System.out.print(result.get(i) + " ");
        }
        System.out.println(" ");
    }
}