package jianzhi_five_one;
import java.util.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
class Solution {
    private int[] getBuck(int[] nums, Map<Integer, Integer> ls){
        Set<Integer> con = new TreeSet(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if (o1 > o2){
                    return -1;
                }
                else if (o1 == o2){
                    return 0;
                }
                return 1;
            }
        });
        for (int i = 0; i < nums.length; ++i){
            con.add(nums[i]);
        }

        int i = 0;
        int[] buck = new int[con.size()];
        for (Integer p : con){
            ls.put(p, i);
            buck[i++] = p;
        }
        return buck;
    }
    int lowbit(int x) {return (x & (-x));}
    void update(int index, int val, int[] Finwick){
        int n = Finwick.length;
        while (index < n){
            Finwick[index] += val;
            index += (lowbit(index + 1));
        }
    }
    int inquiry(int index, int[] Finwick){
        int n = Finwick.length;
        int result = 0;
        while (index >= 0){
            result += Finwick[index];
            index -= (lowbit(index + 1));
        }
        return result;
    }
    public int reversePairs(int[] nums) {
        Map<Integer, Integer> ls = new HashMap<>();
        int[] buck = getBuck(nums, ls);
        int n = buck.length;
        int[] Finwick = new int[n];
        int result = 0;
        for (int i = 0; i < nums.length; ++i){
            int index = ls.get(nums[i]);
            update(index, 1, Finwick);
            result += inquiry(index-1, Finwick);
        }
        return result;
    }
    public static void main(String[] args){
        int[]nums = {2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647};
        System.out.println(new Solution().reversePairs(nums));
    }
}
