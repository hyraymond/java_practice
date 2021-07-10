package seven_four;

//Search a 2D Matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int t = m * n;
        int p = StandardBSearch(0, t - 1, target, matrix);
        if (p == -1)
        {
            return false;
        }
        return true;
    }
    public int StandardBSearch(int b, int e, int target, int[][] arr)
    {
        int m = arr.length;
        int n = arr[0].length;
        int t = m * n;
        if (b < 0 || b > t - 1 || e < 0 || e > t -1)
        {
            return -1;
        }

        if (b >= e)
        {
            if (arr[e/n][e%n] == target)
            {
                return e;
            }
            else
            {
                return -1;
            }
        }

        int mid = (b + e) / 2;
        int temp = arr[mid/n][mid%n];
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
}
