package seven_eight_five;
// Leetcode785, is a graph bipartite.
// Reference: https://leetcode-cn.com/problems/is-graph-bipartite/
import java.util.*;
class Solution {
    private static int RED = 1;
    private static int WHITE = 2;
    private static int UNPAITED = 0;
    private boolean valid = true;
    private int[] color;
    
    public boolean isBipartite(int[][] graph) {
        int n  = graph.length;
        color = new int[n];
        Arrays.fill(color, UNPAITED);
        for (int i = 0; i < n; ++i)
        {
            if (color[i] == UNPAITED)
            {
                dfs(graph, i, RED);
            }
            if (valid == false)
            {
                break;
            }
        }
        return valid;
    }
    void dfs(int[][] graph, int pos, int pos_color)
    {
        color[pos] = pos_color;
        int descendent_color = pos_color == RED? WHITE: RED;

        for(int j: graph[pos])
        {
            if (color[j] == color[pos])
            {
                valid = false;
                return;
            }
            if (color[j] == UNPAITED)
            {
                dfs(graph, j, descendent_color);
            }
        }
    }
    public static void main(String[] args){
        int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        System.out.println(new Solution().isBipartite(graph));
    }
}
