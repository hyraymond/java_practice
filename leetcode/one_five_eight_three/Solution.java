package one_five_eight_three;

import java.util.*;
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] relation = new int[n][n];
        int[] visited = new int[n];
        Map<Integer, Integer> pr = new HashMap<Integer, Integer>();
        int num = 0;

        for (int i = 0; i < n; ++i)
        {
            relation[i][i] = Integer.MAX_VALUE;
            for (int j = 0; j < preferences[i].length; ++j)
            {
                relation[i][preferences[i][j]] = j;
            }
        }

        for (int i = 0; i < pairs.length; ++i)
        {
            pr.put(pairs[i][0], pairs[i][1]);
            pr.put(pairs[i][1], pairs[i][0]);
        }

        for (int i = 0; i < pairs.length; ++i)
        {
            for (int j = 0; j < 2; ++j)
            {
                int a = pairs[i][j];
                int b = pairs[i][(j+1)%2];

                if (visited[a] == 1)
                {
                    continue;
                }
                for (int k = 0; k < n; ++k)
                {
                    if (relation[a][k] < relation[a][b])
                    {
                        int y = pr.get(k);
                        if (relation[k][a] < relation[k][y])
                        {
                            ++num;
                            break;
                        }
                    }
                }
                visited[a] = 1;
            }
        }
        return num;
    }
}
