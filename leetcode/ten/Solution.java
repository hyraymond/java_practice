// Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where: 

// '.' Matches any single character.​​​​
// '*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).
package ten;

public class Solution {
    public static void main(String[] args)
    {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(Solution.isMatch(s, p));
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] OPT = new boolean[m+1][n+1];

        OPT[0][0] = true;

        for (int i = 0; i <= m; ++i)
        {
            for (int j = 1; j <= n; ++j)
            {
                if (p.charAt(j-1) == '*')
                {
                    OPT[i][j] = OPT[i][j-2];
                    if (match(s, p, i, j-1))
                    {
                        OPT[i][j] = OPT[i][j] || OPT[i-1][j];
                    }
                }
                else
                {
                    if (match(s, p, i, j))
                    {
                        OPT[i][j] = OPT[i-1][j-1];
                    }
                }
            }
        }
        return OPT[m][n];

    }
    public static boolean match(String s, String p, int posS, int posP)
    {
        if (posS == 0)
        {
            return false;
        }
        else if (p.charAt(posP-1) == '.')
        {
            return true;
        }
        else
        {
            return s.charAt(posS-1) == p.charAt(posP-1);
        }
    }
}
