package eight_three_six;

import java.util.*;
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int ax1 = Math.max(rec1[0], rec2[0]);
        int ay1 = Math.max(rec1[1], rec2[1]);
        int ax2 = Math.min(rec1[2], rec2[2]);
        int ay2 = Math.min(rec1[3], rec2[3]);
        int a = ax2 - ax1;
        int b = ay2 - ay1;
        if (a <= 0 || b <= 0)
        {
            return false;
        }
        return true;
    }
}
