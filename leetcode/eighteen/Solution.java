//题目：leetcode18，查找等于target的四数之合
//思路：同之前的思路，双指针解法
package eighteen;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int first = 0, second = 0, third = 0, fourth = 0;
        if (0 == nums.length)
        {
            return result;
        }

        Arrays.sort(nums);
        for (first = 0; first < nums.length - 3; ++first)
        {
            if (first !=0 && nums[first] == nums[first - 1])
            {
                continue;
            }
            for(second = first + 1; second < nums.length - 2; ++second)
            {
                if (second != first + 1 && nums[second] == nums[second - 1])
                {
                    continue;
                }

                third = second + 1;
                fourth = nums.length - 1;
                while (third < fourth)
                {
                    int temp = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (temp == target)
                    {
                        List<Integer> tes = List.of(nums[first], nums[second], nums[third], nums[fourth]);
                        result.add(tes);
                        ++third;
                        while(third < fourth && nums[third] == nums[third - 1])
                        {
                            ++third;
                        }
                    }
                    else if (temp < target)
                    {
                        ++third;
                    }
                    else
                    {
                        --fourth;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] tes = {0, 0, 0, 0};
        System.out.println(new Solution().fourSum(tes, 0));
    }
}