package one_one_two_three;
// import java.util.*;

// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     private TreeNode result = null;
//     private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
//         if (root == null){
//             return false;
//         }
//         boolean a = dfs(root.left, p, q);
//         boolean b = dfs(root.right, p, q);
//         if ((a && b) || ((a || b) && (root == p || root == q))){
//             result = root;
//         }
//         return a || b || root == p || root == q;
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         Stack<TreeNode> t= new Stack<TreeNode>();
//         if (null == root){
//             return root;
//         }

//         dfs(root, p, q);
//         return result;
//     }
// }