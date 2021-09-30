package two_three_nine;
import java.util.*;
class node{
    int value;
    int index;
    node(int a, int b)
    {
        value = a;
        index = b;
    }
};
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n - k + 1];
        PriorityQueue<node> q = new PriorityQueue<node>(new Comparator<node>(){
            @Override
            public int compare(node o1, node o2)
            {
                return o2.value - o1.value;
            }
        });
        int start = 0;
        int end = k >= n? n - 1: k-1;
        for (int i = 0; i <= end; ++i)
        {
            q.add(new node(nums[i], i));
        }

        while (end < n)
        {
            while(start != 0 && true)
            {
                int j = q.peek().index;
                if(j < start)
                {
                    q.poll();
                }
                else
                {
                    break;
                }
            }
            f[start] = q.peek().value;
            ++start;
            ++end;
            if (end < n)
            {
                q.add(new node(nums[end], end));
            }
        }
        return f;
    }
}
