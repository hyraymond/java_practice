package one_three_three_nine;

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
    int c = 1000000007;
    long sum = 0;
    long best = 0;
    public int maxProduct(TreeNode root) {
        
        if (root == null)
        {
            return 0;
        }

        dfs(root);
        dfs2(root);
        return (int)((best * (sum - best))%c);
    }
    private void dfs (TreeNode root)
    {
        if (null == root)
        {
            return;
        }
        sum += (long)root.val;
        dfs(root.left);
        dfs(root.right);
    }
    private long dfs2 (TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        long temp = (long)root.val + dfs2(root.left) + dfs2(root.right);
        if (Math.abs(2 * temp - sum) < Math.abs(2 * best - sum))
        {
            best = temp;
        }
        return temp;
    }
}