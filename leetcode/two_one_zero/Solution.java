package two_one_zero;
import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] pre = new int[numCourses];
        int[] picked = new int[numCourses];
        List<Integer> edge[] = new List[numCourses];
        for (int i = 0; i < numCourses; ++i)
        {
            edge[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; ++i){
            int a = prerequisites[i][1];
            int b = prerequisites[i][0];
            edge[a].add(b);
            pre[b]++;
        }

        int[] result = new int[numCourses];
        int sig = 0;
        for (int i = 0; i < numCourses; ++i)
        {
            sig = 0;
            for (int j = 0; j < numCourses; ++j)
            {
                if (picked[j] == 0 && pre[j] == 0){
                    picked[j] = 1;
                    for (Integer p: edge[j]){
                        pre[p]--;
                    }
                    result[i] = j;
                    sig = 1;
                    break;
                }
                if (sig == 0) return null;
            }
        }
        return result;

    }
    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        new Solution().findOrder(numCourses, prerequisites);
    }
}
