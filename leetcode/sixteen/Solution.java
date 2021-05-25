//题目：leetcode16，给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
//返回这三个数的和。假定每组输入只存在唯一答案。
//思路：排序后双指针法，second为头指针，third为尾指针，当所加之和小于0时右移second，大于0时左移third,同15
package sixteen;
import java.util.Arrays;
import java.lang.Math;
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int first = 0, second = 0, third = 0;
        int temp = 0, result = Integer.MAX_VALUE, temp_result = 0;

        Arrays.sort(nums);
        for (first = 0; first < nums.length - 2; ++first)
        {
            second = first + 1;
            third = nums.length - 1;
            while (second < third)
            {
                temp = nums[first] + nums[second] + nums[third];
                if (Math.abs(temp - target) < result)
                {
                    temp_result = temp;
                    result = Math.abs(temp - target);
                }
                if (temp == target)
                {
                    return target;
                }
                else if (temp < target)
                {
                    ++second;
                }
                else
                {
                    --third;
                }
            }
        }
        return temp_result;
    }
}