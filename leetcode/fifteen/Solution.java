//题目：leetcode15，在给定序列中找到三数之和为0的组合，序列中不包含重复元素，组合中也不应该重复使用同一个元素
//思路：排序后双指针法，second为头指针，third为尾指针，当所加之和小于0时右移second，大于0时左移third
package fifteen;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> combine = null;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int tk = 0;
        int first =0, second = 0, third = 0;

        if (nums.length < 3)
        {
            return result;
        }

        Arrays.sort(nums);

        for (first = 0; first < nums.length - 2; ++first)
        {
            if (first !=0 && nums[first] == nums[first - 1])
            {
                continue;
            }
            second = first + 1;
            third = nums.length - 1;
            while(second < third)
            {
                tk = nums[first] + nums[second] + nums[third];
                if (tk == 0)
                {
                    combine = Arrays.asList(nums[first], nums[second], nums[third]);
                    result.add(combine);
                    ++second;
                    while(nums[second] == nums[second - 1] && second < third)
                    {
                        ++second;
                    }
                }
                else if (tk > 0)
                {
                    --third;
                }
                else
                {
                    ++second;
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] tes = {0, 0 ,0 };
        System.out.println(new Solution().threeSum(tes));
    }
}