package one_one_two;
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
//     private boolean dfs(TreeNode root, int targetSum, int temp)
//     {
//         if (root == null)
//         {
//             return false;
//         }

//         temp += root.val;
//         if (root.left == null && root.right == null)
//         {
//             return temp == targetSum;
//         }
//         else
//         {
//             return dfs(root.left, targetSum, temp) || dfs(root.right, targetSum, temp);
//         }
//     }
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         return dfs(root, targetSum, 0);
//     }
// }
