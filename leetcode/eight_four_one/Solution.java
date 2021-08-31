package eight_four_one;

import java.util.*;
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] visited = new int[n];
        int[] result = {0};
        dfs(rooms, 0, visited, result);
        return result[0] == n;
    }
    private void dfs(List<List<Integer>> rooms, int index, int[] visited, int[] result)
    {
        List<Integer> cur = rooms.get(index);
        visited[index] = 1;
        ++result[0];
        for (Integer p: cur)
        {
            int d = p.intValue();
            if (visited[d] == 0)
            {
                dfs(rooms, d, visited, result);
            }
        }
    }
}
