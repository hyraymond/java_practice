package two_one_eight;
import java.util.*;
import java.math.*;

// The Skyline Problem, reference: https://leetcode-cn.com/problems/the-skyline-problem/
// Solution1: self_made, O(n^2), space limit exceeded. Fail.
// Solution2: Use a max heap to track the current height, scan and check all critical points, the left or right edge of the rectangle. Pass all sets. 
// Use BigDecimal and BigInteger, reference: https://blog.csdn.net/weixin_44259720/article/details/87002816
// Use PriorityQueue for max/min heap, default min heap.

// Solution 1:
// class Solution {
//     public static List<List<Integer>> getSkyline(int[][] buildings) {
//         int rbest = 0;
//         int lbest = Integer.MAX_VALUE;
//         int n = buildings.length;
//         if (n == 0)
//         {
//             return null;
//         }
//         for(int i = 0; i < n; ++i)
//         {
//             lbest = lbest > buildings[i][0] ? buildings[i][0] : lbest;
//             rbest = rbest > buildings[i][1] ? rbest : buildings[i][1];
//         }

//         int[] k;
//         if (rbest == Integer.MAX_VALUE)
//         {
//             k = new int[rbest];
//         }
//         else if (rbest == Integer.MAX_VALUE)
//         {
//             k = new int[rbest - 1];
//         }
//         else 
//         {
//             k = new int[rbest + 2];
//         }

//         for(int i = 0; i < n; ++i)
//         {
//             for (int j = buildings[i][0]; j <= buildings[i][1]; ++j)
//             {
//                 k[j] = k[j] < buildings[i][2] ? buildings[i][2] : k[j];
//             }
//         }

//         int temp = k[lbest];
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         ArrayList<Integer> mid = new ArrayList<Integer>();
//         mid.add(lbest);
//         mid.add(k[lbest]);
//         result.add(mid);
//         for (int i = lbest + 1; i < k.length; ++i)
//         {
//             if (k[i] > temp)
//             {
//                 mid = new ArrayList<Integer>();
//                 mid.add(i);
//                 mid.add(k[i]);
//                 result.add(mid);
//                 temp = k[i];
//             }
//             else if (k[i] < temp)
//             {
//                 mid = new ArrayList<Integer>();
//                 mid.add(i - 1);
//                 mid.add(k[i]);
//                 result.add(mid);
//                 temp = k[i];
//             }
//         }

//         return result;
//     }
//     public static void main(String[] args)
//     {
//         int[][] buildings = {{0,2147483647,2147483647}};
//         List<List<Integer>> kk = getSkyline(buildings);
//         for (int i = 0; i < kk.size(); ++i)
//         {
//             for(int j = 0; j < kk.get(0).size(); ++j)
//             {
//                 System.out.print(kk.get(i).get(j) + " ");
//             }
//             System.out.println(" ");
//         }
//     }
// }


// Solution2: 
class node{
    int pix;
    int height;
    node(int a, int b)
    {
        pix = a;
        height = b;
    }
}
class Solution {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        if (n == 0)
        {
            return null;
        }

        node[] critical = new node[2 * n];
        int[] s = new int[2 * n];

        for(int i = 0 ; i < n; ++i)
        {
            critical[i] = new node(buildings[i][0], -buildings[i][2]);
            critical[i + n] = new node(buildings[i][1], buildings[i][2]);
        }

        Arrays.sort(critical, new Comparator<node>(){
            public int compare(node lh, node rh)
            {
                if (lh.pix == rh.pix)
                {
                    if (lh.height > 0 && rh.height > 0)
                    {
                        return Math.abs(lh.height) - Math.abs(rh.height);
                    }
                    else
                    {
                        return Math.abs(rh.height) - Math.abs(lh.height);
                    }
                }
                return lh.pix - rh.pix;
            }
            
        });

        PriorityQueue<Integer> tack = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer lh, Integer rh)
            {
                return rh.compareTo(lh);
            }
        });
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ray;
        int[] cur = {0, 0};

        for(int i = 0; i  < 2 * n; ++i)
        {
            int temp = critical[i].height;
            if (temp < 0)
            {
                tack.add(-temp);   
            }
            else if (temp > 0)
            {
                tack.remove(temp);
            }
            int mip = tack.isEmpty() ? 0: tack.peek();
            if (mip != cur[1])
            {
                ray = new ArrayList<Integer>();
                ray.add(critical[i].pix);
                ray.add(mip);
                result.add(ray);
                cur[0] = critical[i].pix;
                cur[1] = mip;
            }
        }

        return result;
    }
    public static void main(String[] args)
    {
        int[][] tem = {{1,2,1},{1,2,2},{1,2,3}};
        List<List<Integer>> res = new Solution().getSkyline(tem);
        for(int i = 0 ; i < res.size(); ++i)
        {
            for(int j = 0 ; j < res.get(0).size(); ++j)
            {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}
