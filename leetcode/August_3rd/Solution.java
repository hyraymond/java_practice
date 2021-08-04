package August_3rd;

import java.util.*;
class Solution {
    private String arr2string(List<Integer> arr)
    {
        StringBuilder str = new StringBuilder();
        for (int k: arr)
        {
            str.append(k);
        }
        return str.toString();
    }
    private void check(List<Integer> arr, int start, int len, int[] nums, HashSet<String> con, List<List<Integer>> result)
    {
        int n = arr.size();
        if (len >= nums.length)
        {
            return;
        }
        for (int i = start; i < nums.length; ++i)
        {
            if (i != start && nums[i-1] == nums[i])
            {
                continue;
            }
            arr.add(nums[i]);
            String temp = arr2string(arr);
            if (con.contains(temp) == false)
            {
                con.add(temp);
                List<Integer> te = new ArrayList<Integer>();
                te.addAll(arr);
                result.add(te);
            }
            check(arr, i + 1, len + 1, nums, con, result);
            arr.remove(n);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        HashSet<String> con = new HashSet<String>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();

        result.add(new ArrayList<Integer>());
        con.add(arr2string(arr));
        check(arr, 0, 0, nums, con, result);
        
        return result;
    }
    public static void main(String[] args)
    {
        int[] nums = {1, 2 , 3};
        new Solution().subsetsWithDup(nums);
    }
}
