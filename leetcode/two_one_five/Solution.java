package two_one_five;

import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int or = n - k + 1;
        PriorityQueue<Integer> p = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < n; ++i)
        {
            if (p.size() < or)
            {
                p.offer(nums[i]);
            }
            else
            {
                if (nums[i] <  p.peek())
                {
                    p.poll();
                    p.offer(nums[i]);
                }
            }
        }
        return p.peek();
    }
}
