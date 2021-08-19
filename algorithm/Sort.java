import java.util.*;
public class Sort {
    private void quicksort(int[] nums, int start, int end)
    {
        if (start >= end)
        {
            return ;
        }

        int key = nums[start];
        int a = start;
        int b = end;
        while(a < b)
        {
            while (a < b && nums[b] >= key)
            {
                --b;
            }
            
            while (a < b && nums[a] <= key)
            {
                ++a;
            }
            if (a < b)
            {
                int temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
            }

        }
        nums[start] = nums[a];
        nums[a] = key;
        quicksort(nums, start, a - 1);
        quicksort(nums, a + 1, end);
    }
    public static void main(String[] args)
    {
        int[] nums= {1, 4, 3};
        new Sort().quicksort(nums, 0, nums.length-1);
        for (int p : nums)
        {
            System.out.print(p + " ");
        }
    }
}
