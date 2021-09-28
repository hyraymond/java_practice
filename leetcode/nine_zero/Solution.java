package nine_zero;
import java.util.*;
class Solution {
    void check(int[] nums, int index, List<List<Integer>> result, List<Integer> temp)
    {
        if (index == nums.length)
        {
            result.add(new ArrayList<Integer>() {{
                addAll(temp); }});
            return;
        }

        if ((index == 0) || (temp.isEmpty()) || (index > 0 && !temp.isEmpty() && nums[index] != temp.get(temp.size() -1))) check(nums, index+1, result, temp);
        temp.add(nums[index]);
        check(nums, index+1, result, temp);
        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> temp= new ArrayList<Integer>();
        List<List<Integer>> result =new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        check(nums, 0, result, temp);
        return result;
    }
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 3};
        new Solution().subsetsWithDup(nums);
    }
}
