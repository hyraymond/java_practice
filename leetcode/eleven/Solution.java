//题目：leetcode11, 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点
//分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//思路：容器的面积是底乘高，使用头尾两个指针，固定使得底最长，然后高取决于短的那一个，收缩短的一侧。复杂度O(n)
package eleven;
public class Solution {
    public int maxArea(int[] height) {
        int head = 0, tail = height.length - 1;
        int volume = 0;
        int less_height = 0;

        while (head < tail)
        {
            less_height = height[head] < height[tail] ? height[head++] : height[tail--];
            volume = less_height * (tail - head + 1) > volume ? less_height * (tail - head + 1) : volume;
        }
        return volume;
    }
    public static void main (String[] args)
    {
        int height[] = {1,8,6,2,5,4,8,3,7};
        Solution tes = new Solution();
        System.out.println(tes.maxArea(height));
    }
}