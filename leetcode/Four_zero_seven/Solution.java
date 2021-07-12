package Four_zero_seven;

//Trapping Rain Water II
import java.util.*;
class Pos implements Comparable{
    int x;
    int y;
    int val;
    Pos()
    {
        x = 0;
        y = 0;
        val = 0;
    }
    Pos(int a, int b, int c)
    {
        x = a;
        y = b;
        val = c;
    }
    @Override
    public int compareTo(Object o)
    {
        return val - ((Pos)o).val;
    }
}
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int k = 0;
        if (row < 3)
        {
            return 0;
        }
        int col = heightMap[0].length;
        if (col < 3)
        {
            return 0;
        }

        int[][] visit = new int[row][col];
        PriorityQueue<Pos> q = new PriorityQueue<Pos>();

        for (int i: new int[] {0, row - 1})
        {
            for (int j = 0; j < col; ++j)
            {
                q.add(new Pos(i, j, heightMap[i][j]));
                visit[i][j] = 1;
            }
        }

        for (int j: new int[] {0, col - 1})
        {
            for (int i = 1; i < row - 1; ++i)
            {
                q.add(new Pos(i, j, heightMap[i][j]));
                visit[i][j] = 1;
            }
        }

        while (q.isEmpty() == false)
        {
            Pos temp = q.peek();
            q.poll();
            int x = temp.x;
            int y = temp.y;
            int st = temp.val;
            if (x > 0 && visit[x-1][y] == 0)
            {
                if (st > heightMap[x-1][y])
                {
                    k += (st - heightMap[x-1][y]);
                    heightMap[x-1][y] = st;
                }
                q.add(new Pos(x-1, y, heightMap[x-1][y]));
                visit[x-1][y] = 1;
            }
            if (x < row - 1 && visit[x+1][y] == 0)
            {
                if (st > heightMap[x+1][y])
                {
                    k += (st - heightMap[x+1][y]);
                    heightMap[x+1][y] = st;
                }
                q.add(new Pos(x+1, y, heightMap[x+1][y]));
                visit[x+1][y] = 1;
            }
            if (y > 0 && visit[x][y-1] == 0)
            {
                if (st > heightMap[x][y-1])
                {
                    k += (st - heightMap[x][y-1]);
                    heightMap[x][y-1] = st;
                }
                q.add(new Pos(x, y-1, heightMap[x][y-1]));
                visit[x][y-1] = 1;
            }
            if (y < col - 1 && visit[x][y+1] == 0)
            {
                if (st > heightMap[x][y+1])
                {
                    k += (st - heightMap[x][y+1]);
                    heightMap[x][y+1] = st;
                }
                q.add(new Pos(x, y+1, heightMap[x][y+1]));
                visit[x][y+1] = 1;
            }
        }
        return k;
    }
}