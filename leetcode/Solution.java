import java.util.*;
class Solution {
    class node implements Comparable{
        int x;
        int y;
        int val;
        node(int a, int b, int c)
        {
            x = a;
            y = b;
            val = c;
        }
        @Override
        public int compareTo(Object o)
        {
            return val - ((node)o).val;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] ifVisit = new int[m][n];
        PriorityQueue<node> p = new PriorityQueue<node>();
        int key = 0;
        int result = 0;
        for (int i = 0; i < m; ++i)
        {
            ifVisit[i][0] = 1;
            ifVisit[i][n-1] = 1;
            p.add(new node(i, 0, heightMap[i][0]));
            p.add(new node(i, n-1, heightMap[i][n-1]));
        }
        for (int i = 1; i < n - 1; ++i)
        {
            ifVisit[0][i] = 1;
            ifVisit[m-1][i] = 1;
            p.add(new node(0, i, heightMap[0][i]));
            p.add(new node(m-1, i, heightMap[m-1][i]));
        }
        while (!p.isEmpty())
        {
            node temp = p.peek();
            key = temp.val;
            p.poll();
            if (temp.x - 1 >= 0 && ifVisit[temp.x-1][temp.y] == 0)
            {
                ifVisit[temp.x-1][temp.y] = 1;
                if (heightMap[temp.x-1][temp.y] < key)
                {
                    result += (key - heightMap[temp.x-1][temp.y]);
                    heightMap[temp.x-1][temp.y] = key;
                }
                p.add(new node(temp.x-1, temp.y, heightMap[temp.x-1][temp.y]));
            }
            if (temp.x + 1 < m && ifVisit[temp.x+1][temp.y] == 0)
            {
                ifVisit[temp.x+1][temp.y] = 1;
                if (heightMap[temp.x+1][temp.y] < key)
                {
                    result += (key- heightMap[temp.x+1][temp.y]);
                    heightMap[temp.x+1][temp.y] = key;
                }
                p.add(new node(temp.x+1, temp.y, heightMap[temp.x+1][temp.y]));
            }
            if (temp.y - 1 >= 0 && ifVisit[temp.x][temp.y-1] == 0)
            {
                ifVisit[temp.x][temp.y-1] = 1;
                if (heightMap[temp.x][temp.y-1] < key)
                {
                    result += (key - heightMap[temp.x][temp.y-1] );
                    heightMap[temp.x][temp.y-1] = key;
                }
                p.add(new node(temp.x, temp.y-1, heightMap[temp.x][temp.y-1]));
            }
            if (temp.y + 1 < n && ifVisit[temp.x][temp.y+1] == 0)
            {
                ifVisit[temp.x][temp.y+1] = 1;
                if (heightMap[temp.x][temp.y+1] < key)
                {
                    result += (key - heightMap[temp.x][temp.y+1]);
                    heightMap[temp.x][temp.y+1] = key;
                }
                p.add(new node(temp.x, temp.y+1, heightMap[temp.x][temp.y+1]));
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] heightMap = {{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}};
        System.out.println(new Solution().trapRainWater(heightMap));
    }
}