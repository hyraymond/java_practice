package one_two_four;
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
// class Solution {
//     private int max = Integer.MIN_VALUE;
//     private int dfs(TreeNode root){
//         if (root == null){
//             return 0;
//         }
//         int a = dfs(root.left);
//         int b = dfs(root.right);
//         int c = a + b + root.val;
//         int d = Math.max(a, b) + root.val;
//         int e = root.val;
//         max = Math.max(max, Math.max(c, Math.max(d, e)));
//         return Math.max(d, e);
//     }
//     public int maxPathSum(TreeNode root) {
//         dfs(root);
//         return max;
//     }
// }