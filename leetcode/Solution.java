import java.util.*;

public class Solution{
    public static int find(int start, int end, int[] arr)
    {
        if (start == end)
        {
            return arr[start];
        }
        int mid = start + (end - start)/2;
        int n = arr.length;
        if (mid == n - 1)
        {
            return find(n-1, n - 1, arr);
        }
        if (arr[mid] < arr[mid + 1])
        {
            return find(mid + 1, end, arr);
        }
        else
        {
            return find(start, mid, arr);
        }
    }
    public static void main(String[] args){
        int[] arr = {4, 3, 2, 1};
        int[] arr2 = {1 ,2, 3, 4};
        int[] arr3 = {1, 3, 5, 6, 4, 2};
        int result = find(0, arr.length-1, arr);
        System.out.println(find(0, arr.length-1, arr));
        System.out.println(find(0, arr.length-1, arr2));
        System.out.println(find(0, arr.length-1, arr3));
    }
}