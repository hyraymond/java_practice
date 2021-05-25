package search;
public class Solution
{
    int binarySearch(int[] list, int start, int end, int key)
    {
        int mid = (start + end) / 2;

        if (start > end)
        {
            return -1;
        }

        if (key == list[mid])
        {
            return mid;
        }
        else if (key > list[mid])
        {
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
        return binarySearch(list, start, end, key);
    }
    public static void main(String[] args)
    {
        int[] list = {0, 1, 2, 3, 4};
        System.out.println(new Solution().binarySearch(list, 0, 5, 3));
        System.out.println(new Solution().binarySearch(list, 0, 5, -1));
    }
}