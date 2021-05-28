package one_eight;
// 4 sum, reference: https://leetcode-cn.com/problems/4sum/
// Use the sort algorithm offered, reference: https://www.cnblogs.com/minshia/p/6283858.html
// Tips, don't use static method or varient.
import java.util.*;
class Solution {
    private static HashSet<List<Integer>> pos = new HashSet<List<Integer>>();
    private static boolean check(List<List<Integer>> result, List<Integer> temp)
    {
        if (true == pos.contains(temp))
        {
            return false;
        }
        return true;
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int p1 = 0, p2 = 1, p3 = n - 2, p4 = n - 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp;

        for (p1 = 0; p1 < n - 3; ++p1)
        {
            for(p4 = n -1 ; p4 >= p1 + 3; --p4)
            {
                int value = target - nums[p1] - nums[p4];
                p2 = p1 + 1;
                p3 = p4 - 1;
                while(p2 < p3)
                {
                    if (nums[p2] + nums[p3] == value)
                    {
                        temp = new ArrayList<Integer>();
                        temp.add(nums[p1]);
                        temp.add(nums[p2]);
                        temp.add(nums[p3]);
                        temp.add(nums[p4]);
                        if (check(result, temp) == true)
                        {    
                            result.add(temp);
                            pos.add(temp);
                        }
                        ++p2;
                    }
                    else if (nums[p2] + nums[p3] > value)
                    {
                        --p3;
                    }
                    else
                    {
                        ++p2;
                    }
                }
            }
        }
        for(List<Integer> pp: result)
        {
            System.out.println(pp);
        }

        return result;
    }
    public static void main(String[] args)
    {
        int []nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));
    }
}