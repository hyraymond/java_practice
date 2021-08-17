import four.*;
import java.util.*;
abstract class p1{
    static{
        System.out.println("this is p1");
    }
}
class tes {
    int M = 1000000007;
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;
            } else {
                dp[i + 1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i - 1) == '1')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                else if (s.charAt(i - 1) == '*')
                    dp[i + 1] = (dp[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1]) % M;
            }
            dp[i + 1] %= M;
        }
        return (int) dp[s.length()];
    }
    public static void main(String[] args)
    {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        p.add(3);
        p.add(4);
        p.add(2);
        for (Integer q:p)
        {
            System.out.print(q+" ");
        }
        System.out.println(" ");
        System.out.println(false == p.remove(1));
        for (Integer q:p)
        {
            System.out.print(q+" ");
        }
        System.out.println(" ");
    }
    
}