package four_four_seven;
import java.util.*;
class Solution {
    private int range(int x1, int y1, int x2, int y2)
    {
        int x = x1 - x2;
        int y = y1 - y2;
        return x * x + y * y;
    }
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int result = 0;
        for (int i = 0; i < n; ++i)
        {
            Map<Integer, Integer> con = new HashMap<Integer, Integer>();
            for (int j = 0; j < n; ++j)
            {
                if (i != j)
                {
                    int temp = range(points[i][0], points[i][1], points[j][0], points[j][1]);
                    int num = con.getOrDefault(temp, 0);
                    con.put(temp, num + 1);
                }
            }
            for (Integer p: con.values())
            {
                int m = p.intValue();
                result += ((m - 1) * m);
            }
        }

        return result;
    }
}