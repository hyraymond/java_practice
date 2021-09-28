package one_one_three;
import java.util.*;
// class Solution {
//     private void dfs(TreeNode root, int targetSum, int temp, List<Integer> con, List<List<Integer>> result)
//     {
//         if (root == null)
//         {
//             return;
//         }

//         temp += root.val;
//         con.add(root.val);
//         if (root.left == null && root.right == null)
//         {
//             if (temp == targetSum)
//             {
//                 result.add(new ArrayList<Integer>() {{
//                     addAll(con);
//                 }});
//             }
//         }
//         else
//         {
//             dfs(root.left, targetSum, temp, con, result);
//             dfs(root.right, targetSum, temp, con, result);
//         }
//         con.remove(con.size() - 1);
//     }
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         List<Integer> con = new ArrayList<Integer>();
//         List<List<Integer>> result = new ArrayList<List<Integer>> ();
//         dfs(root, targetSum, 0, con, result);
//         return result;
//     }
// }

