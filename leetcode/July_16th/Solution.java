package July_16th;

// 4sum, beats 65%
import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        Set<String> red = new HashSet<String>();
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 4)
        {
            return output;
        }
        for(int i = 0; i < n - 3; ++i)
        {
            for (int j = i + 3; j < n; ++j)
            {
                int start = i + 1;
                int end = j - 1;
                while (start < end)
                {
                    int temp = nums[i] + nums[start] + nums[end] + nums[j];
                    if (temp == target)
                    {
                        StringBuilder ti = new StringBuilder();
                        ti.append(nums[i]);
                        ti.append(nums[start]);
                        ti.append(nums[end]);
                        ti.append(nums[j]);
                        String it = ti.toString();
                        if (red.contains(it) == false)
                        {
                            red.add(it);
                            List<Integer> te = new ArrayList<Integer>();
                            te.add(nums[i]);
                            te.add(nums[start]);
                            te.add(nums[end]);
                            te.add(nums[j]);
                            output.add(te);
                        }   
                        ++start;
                    }
                    else if (temp > target)
                    {
                        --end;
                    }
                    else
                    {
                        ++start;
                    }
                }
            }
        }
        return output;
    }
    public static void main(String[] args)
    {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(new Solution().fourSum(nums, 8));
    }
}
