package two_zero_seven;
// Course Schedule, question reference: https://leetcode-cn.com/problems/course-schedule/
// This question equals to cycle detection, use DFS to see if there is a back edge.
import java.util.*;
class Solution {
    private boolean[] isVisited;
    private boolean[] isInStack;
    private boolean valid = true;
    private ArrayList<Integer> neighbors[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        isVisited = new boolean[numCourses];
        isInStack = new boolean[numCourses];
        Arrays.fill(isVisited, false);
        Arrays.fill(isInStack, false);
        neighbors = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; ++i)
        {
            neighbors[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; ++i)
        {
            neighbors[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; ++i)
        {
            if (isVisited[i] == false)
            {
                dfs(i);
            }
        }

        return valid;
    }
    void dfs(int node)
    {
        if (isVisited[node] == true)
        {
            return;
        }

        isVisited[node] = true;
        isInStack[node] = true;
        for (int T: neighbors[node])
        {
            if (isInStack[T] == true)
            {
                valid = false;
                return;
            }
            if (isVisited[T] == false)
            {
                dfs(T);
            }
        }
        isInStack[node] = false;
    }
    public static void main(String[] args)
    {
        int numCourses = 2;
        int [][]prerequisites = {{1, 0}}; 
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
