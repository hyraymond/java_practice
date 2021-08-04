package August_4th;

import java.util.*;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            }
    }
    private void check(List<List<Integer>> result, List<Integer> temp, TreeNode root, int targetSum, int tempSum)
    {
        if (root == null)
        {
            return;
        }
        int te = tempSum + root.val;
        if (te == targetSum)
        {
            List<Integer> or = new ArrayList<Integer>();
            or.addAll(temp);
            result.add(or);
        }
        else
        {
            int n = temp.size();
            if (root.left != null)
            {
                int k = root.left.val;
                temp.add(k);
                check(result, temp, root.left, targetSum, te);
                temp.remove(n);
            }
            if (root.left != null)
            {
                int k = root.right.val;
                temp.add(k);
                check(result, temp, root.right, targetSum, te);
                temp.remove(n);
            }
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        check(result, temp, root, targetSum, 0);
        return result;
    }
    public static void main(String[] args)
    {
        Solution.TreeNode root = new Solution().new TreeNode();
        root.val = -2;
        root.left = null;
        root.right = new Solution().new TreeNode(-3);
        new Solution().pathSum(root, -5);
    }
}
