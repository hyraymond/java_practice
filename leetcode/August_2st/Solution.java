package August_2st;

import java.util.*;
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;

        Integer[] temp = new Integer[nums.length];

        for (int i = 0; i < nums.length; ++i)
        {
            temp[i] = i;
        }
        Arrays.sort(temp, new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1] - nums[o2];
            }
            
        });

        while(start < end)
        {
            int te = nums[temp[start]] + nums[temp[end]];
            if (te == target)
            {
                break;
            }
            else if (te > target)
            {
                --end;
            }
            else
            {
                ++start;
            }
        }
        result[0] = temp[start];
        result[1] = temp[end];
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println("fdsalk");
    }
}
