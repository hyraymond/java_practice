//  Find K Closest Elements
// Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

// An integer a is closer to x than an integer b if:

// |a - x| < |b - x|, or
// |a - x| == |b - x| and a < b

package July_2nd;

import java.util.*;
import java.util.stream.*;
import java.io.*;

//Solution1, pass all data sets, only beats 21%.
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         int l = arr[0];
//         int h = arr[arr.length - 1];
//         List<Integer> result = new ArrayList<Integer>();

//         IntStream stream = Arrays.stream(arr);
//         Stream integerStream = stream.boxed();
//         Integer[] integers = (Integer[]) integerStream.toArray(Integer[]::new);

//         if (x <= l)
//         {
//             for (int i = 0; i < k; ++i)
//             {
//                 result.add(arr[i]);
//             }
//             return result;
//         }

//         if (x <= l)
//         {
//             int n = arr.length;
//             for (int i = 0; i < k; ++i)
//             {
//                 result.add(arr[n - 1 -i]);
//             }
//             return result;
//         }

        

//         Arrays.sort(integers, new Comparator<Integer>() {

//             @Override
//             public int compare(Integer o1, Integer o2) {
//                 int a = Math.abs((int) o1 - x);
//                 int b = Math.abs((int) o2 - x);
//                 if (a != b)
//                 {
//                     return a - b;
//                 }
//                 else
//                 {
//                     return o1 - o2;
//                 }
//             }

//         });

//         Integer[] q = Arrays.copyOfRange(integers, 0, k);
//         Arrays.sort(q);

//         for (int i = 0; i < k; ++i)
//         {
//             result.add(q[i]);
//         }

//         return result;
//     }
//     public static void main(String[] args)
//     {
//         int[] arr = {1, 2 , 3, 4, 5};
//         System.out.println(new Solution().findClosestElements(arr, 4, 3));
//     }
// }

//Solution2, pass all data sets, only beats 25%.
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; ++i)
        {
            if (result.size() < k)
            {
                result.add(arr[i]);
            }
            else
            {
                int temp = Math.abs(result.get(0) - x);
                int chan = Math.abs(arr[i] - x);
                if (temp > chan)
                {
                    result.remove(0);
                    result.add(arr[i]);
                }
                else if (temp == chan)
                {
                    continue;
                }
                else
                {
                    break;
                }
            }
        }

        return result;
    }
}
