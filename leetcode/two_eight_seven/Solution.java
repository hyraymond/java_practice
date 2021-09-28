package two_eight_seven;
import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int i = 0;
        int key = 0;
        while (i < nums.length)
        {
            key = nums[i];
            if (key == nums[key])
            {
                break;
            }
            else
            {
                int temp = nums[i];
                nums[i] = nums[key];
                nums[key] = temp;
            }
        }
        return key;
    }
}