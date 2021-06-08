package five_one_four;

// 514. Freedom Trail, reference: https://leetcode-cn.com/problems/freedom-trail/
// Solution1: Greedy Algorithem, Failed, clearly.
// Solution2: Offficial Answer, to be continue.
// Use Arrays.stream, reference: https://blog.csdn.net/a13662080711/article/details/84928181

import java.util.*;
// class Solution {
//     public static public DP(int[] dp, )
//     public static int findRotateSteps(String ring, String key) {
//         int n = ring.length();
//         int m = key.length();
//         int[] dp = new int[m];
//         int[] track = new int[m];

//         Set<Character> pic = new HashSet<Character>();
//         for(int i = 0; i < n; ++i)
//         {
//             pic.add(ring.charAt(i));
//         }

//         Map<Character, List<Integer>> dic = new HashMap<Character, List<Integer>>();
//         List<Integer> temp;

//         for(char p: pic)
//         {
//             temp = new ArrayList<Integer>();
//             for(int i = 0; i < n; ++i)
//             {
//                 if (p == ring.charAt(i))
//                 {
//                     temp.add(i);
//                 }
//             }
//             dic.put(p, temp);
//         }

//         int cur_index = 0;
//         for(int i = 0; i < m; ++i)
//         {
//             char cur = key.charAt(i);
//             temp = dic.get(cur);
//             int sta = Integer.MAX_VALUE;
//             int move = 0;
//             for(int index: temp)
//             {
//                 int dif1 = Math.abs(cur_index - index);
//                 int dif2 = n - dif1;
//                 int dif = dif1 < dif2? dif1 : dif2; 
//                 if (dif < sta)
//                 {
//                     sta = dif;
//                     move = index;
//                 }
//             }
//             cur_index = move;
//             if (i == 0)
//             {
//                 dp[i] = sta;
//             }
//             else
//             {
//                 dp[i] = sta + dp[i - 1];
//             }
//         }

//         return dp[m - 1] + m;
//     }
//     public static void main(String[] args)
//     {
//         String ring = "godding", key = "gd";
//         System.out.println(findRotateSteps(ring, key));
//     }
// }

// Solution2
class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
