package July_6th;

// Reduce Array Size to The Half

import java.util.*;
import java.util.Map.Entry;

// pass all data sets, beats 11%.
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        Queue<Integer> po = new PriorityQueue<Integer>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return table.get(o2) - table.get(o1);
            }
        });
        for (int i = 0; i < arr.length; ++i)
        {
            if (table.containsKey(arr[i]) == true)
            {
                int temp = table.get(arr[i]);
                table.put(arr[i], temp+1);
            }
            else
            {
                table.put(arr[i], 1);
            }
        }
        Set<Integer> hy = table.keySet();
        for (int j : hy)
        {
            po.add(j);
        }

        int temp = 0;
        int num = 0;
        while(po.isEmpty() == false)
        {
            temp += table.get(po.peek());
            ++num;
            if (temp * 2 >= arr.length)
            {
                break;
            }
            po.poll();
        }
        return num;
    }
    public static void main(String[] args)
    {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(new Solution().minSetSize(arr));
    }
}
