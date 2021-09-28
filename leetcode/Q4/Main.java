package Q4;
import java.util.*;
public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            int n = in.nextInt();
            for (int i = 0; i < n; ++i)
            {
                int len = in.nextInt();
                int[] arr = new int[len];
                Integer[] num = new Integer[len];
                for (int j = 0; j < len; ++j)
                {
                    arr[j] = in.nextInt();
                    num[j] = j;
                }
                Arrays.sort(num, new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2)
                    {
                        return arr[o1] - arr[o2];
                    }
                });

                int start = len-2;
                int end = len-1;
                int result = 0;
                List<Integer> a = new LinkedList<Integer>();
                List<Integer> b = new LinkedList<Integer>();
                while (arr.length > 1 && arr[num[start]] > 0 && arr[num[end]] > 0)
                {
                    while (arr[num[start]] > 0 && arr[num[end]] > 0)
                    {
                        arr[num[start]]--;
                        a.add(num[start] + 1);
                        arr[num[end]]--;
                        b.add(num[end] + 1);
                        ++result;
                    }
                    Arrays.sort(num, new Comparator<Integer>(){
                        @Override
                        public int compare(Integer o1, Integer o2)
                        {
                            return arr[o1] - arr[o2];
                        }
                    });
                }
                System.out.println(result);
                for (int p = 0; p < a.size(); ++p)
                {
                    int lv = Math.min(a.get(p), b.get(p));
                    int rv = Math.max(a.get(p), b.get(p));
                    System.out.println(lv + " " + rv);
                }
            }
        }
    }
}
