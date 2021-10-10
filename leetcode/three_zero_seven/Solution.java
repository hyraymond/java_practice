package three_zero_seven;
import java.util.*;
class STNode{
    int start;
    int end;
    STNode left;
    STNode right;
    int sum;
    STNode(){
        start = 0;
        end = 0;
        left = null;
        right = null;
        sum = 0;
    }
}
class NumArray {
    STNode gen;
    private STNode STBuild(int start, int end, int[] nums){
        STNode cur = new STNode();
        cur.start = start;
        cur.end = end;

        if (start == end){
            cur.sum = nums[start];
            return cur;
        }

        int mid = (start + end)/2;
        STNode left = STBuild(start, mid, nums);
        STNode right = STBuild(mid+1, end, nums);
        cur.left = left;
        cur.right = right;
        cur.sum = left.sum + right.sum;
        return cur;
    }
    public NumArray(int[] nums) {
        int n = nums.length;
        gen = STBuild(0, n-1, nums);
    }
    
    private void update(STNode root, int index, int val){
        if (root.start == root.end){
            if (root.start == index){
                root.sum = val;
            }
            return;
        }
        int mid = (root.start + root.end)/2;
        if (index <= mid){
            update(root.left, index, val);
        }
        else{
            update(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    public void update(int index, int val) {
        update(gen, index, val);
    }
    
    public int sumRange(STNode root, int left, int right) {
        if (root.start == left && root.end == right){
            return root.sum;
        }
        int mid = (root.start + root.end)/2;
        if (right <= mid){
            return sumRange(root.left, left, right);
        }
        if (left > mid){
            return sumRange(root.right, left, right);
        }
        return sumRange(root.left, left, mid) + sumRange(root.right, mid+1, right);
    }
    public int sumRange(int left, int right) {
        return sumRange(gen, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 *
 */