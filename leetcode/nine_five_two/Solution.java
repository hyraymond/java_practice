package nine_five_two;
// Largest Component Size by Common Factor, reference: https://leetcode-cn.com/problems/largest-component-size-by-common-factor/
// Solution1: check every pair of numbers, find out if they share a common factor larger than 1, if so merge their union. Time Limit Exceeded.
// Solution2: find all the prime factors of numbers, merge them by prime factors. Pass all set.
// Mathmatic Theorem: Every composite nunber is the product of several prime numbers.
import java.util.*;

// Solution1: 
// class Solution {
    
//     private static int[] father;
//     private static int[] father_size;
//     private static int best;
//     private static int least(int lh, int rh)
//     {
//         int ltemp = 0;
//         int rtemp = 0;

//         if (lh > rh)
//         {
//             ltemp = lh;
//             rtemp = rh;
//         }
//         else
//         {
//             ltemp = rh;
//             rtemp = lh;
//         }
//         int temp = ltemp % rtemp;
//         while (temp != 0)
//         {
//             ltemp = rtemp;
//             rtemp = temp;
//             temp = ltemp % rtemp;
//         }
//         return rtemp;
//     }
//     private static void union_ini(int n)
//     {
//         father = new int[n];
//         father_size = new int[n];
//         best = 0;
//         for(int i = 0; i < n; ++i)
//         {
//             father[i] = i;
//             father_size[i] = 1;
//         }
//     }
//     private static int father_find(int index)
//     {
//         int temp = father[index];
//         if (temp == index)
//         {
//             return index;
//         }
//         else
//         {
//             return father[index] = father_find(temp);
//         }
//     }
//     private static void union_merge(int lh, int rh)
//     {
//         int lf = father_find(lh);
//         int rf = father_find(rh);
//         if (lf < rf)
//         {
//             father[rf] = lf;
//             father_size[lf] += father_size[rf];
//             father_size[rf] = 0;
//         }
//         else if (lf > rf)
//         {
//             father[lf] = rf;
//             father_size[rf] += father_size[lf];
//             father_size[lf] = 0;
//         }

//         if (lf != rf)
//         {
//             int temp = father_size[rf] + father_size[lf];
//             best = best > temp ? best : temp;
//         }
//     }
//     public static int largestComponentSize(int[] nums) {
//         int n = nums.length;

//         if (n == 0)
//         {
//             return 0;
//         }

//         union_ini(n);

//         for(int i = 0; i < n; ++i)
//         {
//             for (int j = i + 1; j < n; ++j)
//             {
//                 if (least(nums[i], nums[j]) > 1)
//                 {
//                     union_merge(i, j);
//                 }
//             }
//         }
//         return best;
//     }
//     public static void main(String[] args)
//     {
//         int[] tem = {20,50,9,63};
//         System.out.println(largestComponentSize(tem));
//     }
// }

// Solution2: Sample
// class Solution {
//     public int largestComponentSize(int[] A) {
//         int N = A.length;

//         // factored[i] = a list of unique prime factors of A[i]
//         ArrayList<Integer>[] factored = new ArrayList[N];
//         for (int i = 0; i < N; ++i) {
//             factored[i] = new ArrayList<Integer>();
//             int d = 2, x = A[i];
//             while (d * d <= x) {
//                 if (x % d == 0) {
//                     while (x % d == 0)
//                         x /= d;
//                     factored[i].add(d);
//                 }

//                 d++;
//             }

//             if (x > 1 || factored[i].isEmpty())
//                 factored[i].add(x);
//         }

//         // primesL : a list of all primes that occur in factored
//         Set<Integer> primes = new HashSet();
//         for (List<Integer> facs: factored)
//             for (int x: facs)
//                 primes.add(x);

//         int[] primesL = new int[primes.size()];
//         int t = 0;
//         for (int x: primes)
//             primesL[t++] = x;

//         // primeToIndex.get(v) == i  iff  primes[i] = v
//         Map<Integer, Integer> primeToIndex = new HashMap();
//         for (int i = 0; i < primesL.length; ++i)
//             primeToIndex.put(primesL[i], i);

//         DSU dsu = new DSU(primesL.length);
//         for (List<Integer> facs: factored)
//             for (int x: facs)
//                 dsu.union(primeToIndex.get(facs.get(0)), primeToIndex.get(x));

//         int[] count = new int[primesL.length];
//         for (List<Integer> facs: factored)
//             count[dsu.find(primeToIndex.get(facs.get(0)))]++;

//         int ans = 0;
//         for (int x: count)
//             if (x > ans)
//                 ans = x;
//         return ans;
//     }
//     public static void main(String[] args)
//     {
//         int[] tem = {10,200, 6400,20};
//         System.out.println(new Solution().largestComponentSize(tem));
//     }
// }

// class DSU {
//     int[] parent;
//     public DSU(int N) {
//         parent = new int[N];
//         for (int i = 0; i < N; ++i)
//             parent[i] = i;
//     }
//     public int find(int x) {
//         if (parent[x] != x) parent[x] = find(parent[x]);
//         return parent[x];
//     }
//     public void union(int x, int y) {
//         parent[find(x)] = find(y);
//     }
// }

// Solution2: Self-made
class Solution {
    private static int find_father(int[] father, int i)
    {
        int temp = father[i];
        if (i == temp)
        {
            return i;
        }
        else
        {
            return father[i] = find_father(father, temp);
        }
    }
    private static void merge(int[] father, int lh, int rh)
    {
        int lf = find_father(father, lh);
        int rf = find_father(father, rh);
        if (lf < rf)
        {
            father[rf] = lf;
        }
        else if (lf > rf)
        {
            father[lf] = rf;
        }
    }
    public static int largestComponentSize(int[] A) {
        int n = A.length;
        List<Integer>[] factor = new ArrayList[n];
        for(int i = 0; i < n; ++i)
        {
            int x = A[i];
            int k = 2;
            factor[i] = new ArrayList<Integer>();
            while (k * k <= x)
            {
                if (x % k == 0)
                {
                    while(x % k ==0)
                    {
                        x /= k;
                    }
                    factor[i].add(k);
                }
                ++k;
            }
            if (x > 1 || factor[i].isEmpty())
            {
                factor[i].add(x);
            }
        }
        
        Set<Integer> prime = new HashSet<Integer>();
        for (int i = 0; i < n; ++i)
        {
            for (Integer p: factor[i])
            {
                prime.add(p);
            }
        }

        int nn = prime.size();
        int[] father = new int[nn];
        int i = 0;
        Map<Integer, Integer> tem = new HashMap<Integer, Integer>();
        for (Integer p: prime)
        {
            tem.put(p, i);
            father[i] = i;
            i++;
        }

        for (i = 0; i < n; ++i)
        {
            for (Integer p: factor[i])
            {
                merge(father, tem.get(factor[i].get(0)), tem.get(p));
            }
        }

        int[] count = new int[nn];
        for (i = 0; i < n; ++i)
        {
                count[find_father(father, tem.get(factor[i].get(0)))]++;
        }

        int best = 0;
        for (i = 0; i  < nn; ++i)
        {
            best = best < count[i] ? count[i] : best;
        }

        return best;
    }
    public static void main(String[] args)
    {
        int[] tem = {4, 6, 15, 35};
        System.out.println(largestComponentSize(tem));
    }
}