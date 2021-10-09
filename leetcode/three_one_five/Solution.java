package three_one_five;
import java.util.*;
class Solution {
    private void getBuckNum(int[] nums, Map<Integer, Integer> tem){
        int n = nums.length;
        Set<Integer> con = new TreeSet<>();

        // Arrays.sort(nums);
        for (int i = 0; i < n; ++i){
            con.add(nums[i]);
        }

        int i = 0;
        for (int p: con){
            tem.put(p, i++);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> tem = new HashMap<Integer, Integer>();
        LinkedList<Integer> re = new LinkedList<Integer>();
        getBuckNum(nums, tem);
        int m = tem.size();
        int[] prefix = new int[m];
        int[] buck = new int[m];

        for (int i = n - 1; i >= 0; --i){
            int key = nums[i];
            int index = tem.get(key);
            buck[index]++;
            for (int j = index; j < m; ++j){
                prefix[j]++;
            }
            int me = index > 0? prefix[index-1]: 0;
            re.add(0, me);
        }
        return re;
    }
    public static void main(String[] args){
        int[] nums = {-1, -2};
        List<Integer> j = new Solution().countSmaller(nums);
        for(Integer p: j){
            System.out.print(p + " ");
        }
    }
}
