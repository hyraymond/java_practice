package one_one_three_six;
import java.util.*;
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] pre = new int[n+1];
        int[] visited = new int[n+1];
        List<Integer> [] edge = new ArrayList[n+1];

        if (relations == null){
            return 1;
        }
        for (int i = 1; i <= n; ++i){
            edge[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < relations.length; ++i){
            int a = relations[i][0];
            int b = relations[i][1];
            pre[b]++;
            edge[a].add(b);
        }
        for (int i = 1; i <= n; ++i){
            if (pre[i] == 0){
                visited[i] = 1;
                q.offer(i);
            }
        }
        int sem = 0;
        while(!q.isEmpty()){
            ++sem;
            while(!q.isEmpty()){
                int p = q.poll();
                for (Integer temp: edge[p]){
                    pre[temp]--;
                }
            }
            for(int i = 1; i <= n; ++i){
                if (pre[i] == 0 && visited[i] == 0){
                    visited[i] = 1;
                    q.offer(i);
                }
            }
        }
        for (int i = 1; i <= n; ++i){
            if (visited[i] == 0){
                return -1;
            }
        }
        return sem;
    }
}