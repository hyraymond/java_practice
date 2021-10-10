package two_eight_zero;
import java.util.*;
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int mid = (n-1)/2;
        int n1 = mid + 1;
        int n2 = n - n1;
        int[] left = new int[n1];
        int[] right = new int[n2];
        Arrays.sort(nums);
        int i = n-1;
        for (int j = 0; j < n2; ++j){
            right[j] = nums[i--];
        }
        for (int j = 0; j < n1; ++j){
            left[j] = nums[i--];
        }
        i = 0;
        int p1 = 0;
        int p2 = 0;
        while (i < n){
            nums[i++] = left[p1++];
            if (i < n) nums[i++] = right[p2++];
        }
    }
}
