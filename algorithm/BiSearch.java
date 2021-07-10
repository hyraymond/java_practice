// Binary Search algorithm, including standard binary search algorithm, find the left border, find the right border
// find both sides borders, find the local extremum.

import java.util.*;

public class BiSearch {
    public int StandardBSearch(int b, int e, int target, int[] arr)
    {
        int n = arr.length;
        if (b < 0 || b > n - 1 || e < 0 || e > n -1)
        {
            return -1;
        }

        if (b >= e)
        {
            if (arr[e] == target)
            {
                return e;
            }
            else
            {
                return -1;
            }
        }

        int mid = (b + e) / 2;
        int temp = arr[mid];
        if (temp == target)
        {
            return mid;
        }
        else if (temp > target)
        {
            return StandardBSearch(b, mid - 1, target, arr);
        }
        else
        {
            return StandardBSearch(mid + 1, e, target, arr);
        }
    }
    public int leftBSearch(int b, int e, int target, int[] arr)
    {
        int n = arr.length;
        if (b < 0 || b > n - 1 || e < 0 || e > n -1)
        {
            return -1;
        }

        if (b >= e)
        {
            if (arr[b] == target)
            {
                return b;
            }
            else
            {
                return -1;
            }
        }

        int mid = (b + e) / 2;
        int temp = arr[mid];
        if (temp > target)
        {
            return leftBSearch(b, mid, target, arr);
        }
        else if(temp < target)
        {
            return leftBSearch(mid + 1, e, target, arr);
        }
        else 
        {
            return leftBSearch(b, mid - 1, target, arr);
        }
    }
    public int rightBSearch(int b, int e, int target, int[] arr)
    {
        int n = arr.length;
        if (b < 0 || b > n - 1 || e < 0 || e > n -1)
        {
            return -1;
        }

        if (b >= e)
        {
            if (arr[e] == target)
            {
                return e;
            }
            else
            {
                return -1;
            }
        }

        int mid = (b + e)/2;
        int temp = arr[mid];
        if (temp > target)
        {
            return rightBSearch(b, mid - 1, target, arr);
        }
        else if(temp < target)
        {
            return rightBSearch(mid, e, target, arr);
        }
        else
        {
            return rightBSearch(b + 1, e, target, arr);
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 55, 55, 55, 55, 199, 224, 10503};
        System.out.println(new BiSearch().StandardBSearch(0, arr.length - 1, 55, arr));
        System.out.println(new BiSearch().leftBSearch(0, arr.length - 1, 55, arr));
        System.out.println(new BiSearch().rightBSearch(0, arr.length - 1, 55, arr));
    }
}
