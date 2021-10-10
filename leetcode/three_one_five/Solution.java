package three_one_five;
import java.util.*;
class STNode{
    int start;
    int end;
    STNode left;
    STNode right;
    int val;
    STNode(){
        start = 0;
        end = 0;
        left = null;
        right = null;
        val = 0;
    }
}
class NumArray {
    STNode gen;
    private STNode STBuild(int start, int end, int[] nums){
        STNode cur = new STNode();
        cur.start = start;
        cur.end = end;

        if (start == end){
            cur.val = nums[start];
            return cur;
        }

        int mid = (start + end)/2;
        STNode left = STBuild(start, mid, nums);
        STNode right = STBuild(mid+1, end, nums);
        cur.left = left;
        cur.right = right;
        return cur;
    }
    public NumArray(int[] nums) {
        int n = nums.length;
        gen = STBuild(0, n-1, nums);
    }
    
    private void update(STNode root, int start, int end, int val){
        if(root.start == start && root.end == end){
            val += val;
            return;
        }
        int mid = (root.start + root.end)/2;
        if (end <= mid){
            update(root.left, start, mid, val);
        }
        else{
            update(root.right, mid+1, end, val);
        }
    }

    public void update(int start, int end, int val){
        update(gen, start, end, val);
    }
    
    private int inquiry(STNode root, int index){
        if (root.start == root.end){
            if (index == root.start){
                return root.val;
            }
            else{
                return 0;
            }
        }
        int mid = (root.start + root.end)/2;
        if (index <= mid){
            return root.val + inquiry(root.left, index);
        }
        else{
            return root.val + inquiry(root.right, index);
        }
    }

    public int inquiry(int index){
        return inquiry(gen, index);
    }
}
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

        NumArray tree = new NumArray(prefix);

        for (int i = n - 1; i >= 0; --i){
            int key = nums[i];
            int index = tem.get(key);
            buck[index]++;
            tree.update(index, m-1, 1);
            int me = index > 0? tree.inquiry(index-1): 0;
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
