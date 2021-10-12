import java.util.*;

public class Solution extends HashMap<Integer, Integer>{
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
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > 2;
    }
    public static void main(String[] args){
        Set<Integer> q = new HashSet<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        Iterator<Integer> p = q.iterator();
        while(p.hasNext()){
            int k = p.next();
            if (k == 2){
                p.remove();
            }
        }
        for (Integer j: q){
            System.out.println(j);
        }
    }
}