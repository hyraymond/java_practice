import java.util.*;

public class Solution {
    public static void tes(int[] nums, int index, PriorityQueue<Integer> con, int[] result)
    {
        int n = nums.length;
        if (index < 0)
        {
            for (int i = 0; i < n; ++i)
            {
                result[i] = con.peek();
                con.poll();
            }
        }
        else 
        {
            if (!con.isEmpty() && nums[index] < con.peek())
            {
                for (int i = 0; i < index; ++i)
                {
                    result[i] = nums[i];
                }
                for (int i = index; i < n-1; ++i)
                {
                    result[i] = con.peek();
                    con.poll();
                }
                result[n-1] = nums[index];
            }
            else
            {
                con.offer(nums[index]);
                tes(nums, index-1, con, result);
            }
        }

    }
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        int[] nums = {5, 4, 3, 2, 1};
        int[] result = new int[nums.length];
        PriorityQueue<Integer> con = new PriorityQueue<Integer>();
        tes(nums, nums.length-1 , con, result);
        for (int i = 0; i < nums.length; ++i)
        {
            System.out.print(result[i] + " ");
        }
        System.out.println(" ");

    }
}