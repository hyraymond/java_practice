package three_four_two;
// Power of Four, reference: https://leetcode-cn.com/problems/power-of-four/
// Use the Math.log
import java.util.*;
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0)
        {
            return false;
        }
        int a = (int)(Math.log(n)/Math.log(4));
        return Math.pow(4, a) == n;
    }
}
    public static void main(String[] args)
    {
        int n = 0;
        int a = (int)(Math.log(n)/Math.log(4));
        System.out.println(Math.pow(4, a));
    }
}
