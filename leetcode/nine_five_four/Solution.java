package nine_five_four;

import java.util.*;
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        Integer[] num = new Integer[n];
        int[] visited = new int[n];
        int check = 0;
        for (int i = 0; i < n; ++i)
        {
            num[i] = arr[i];
        }
        Arrays.sort(num, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for (int i = 0; i < n; ++i)
        {
            if (visited[i] == 0)
            {
                for(int j = i + 1; j < n; ++j)
                {
                    if (visited[j] == 0 && num[i].intValue() * 2 == num[j].intValue())
                    {
                        visited[i] = 1;
                        visited[j] = 1;
                        check += 2;
                        break;
                    }
                }
            }
        }
        return check == n;
    }
}
