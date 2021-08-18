package one_four_four_eight;

import java.util.*;
// Definition for a binary tree node.
class TreeNode {
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

class Solution {
    private int result = 0;
    public int goodNodes(TreeNode root) {
        PriorityQueue<Integer> con = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        dfs(root, con);
        return result;
    }
    private void dfs(TreeNode root, PriorityQueue<Integer> con)
    {
        if (root == null)
        {
            return;
        }
        int cur = root.val;
        int temp = con.isEmpty()? Integer.MIN_VALUE: con.peek();
        if (cur >= temp)
        {
            ++result;
        }
        con.offer(cur);
        if (root.left != null)
        {
            dfs(root.left, con);
        }
        if (root.right != null)
        {
            dfs(root.right, con);
        }
        con.remove(cur);
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(4);
        TreeNode cur = root.right;
        cur.left = new TreeNode(10);
        cur.right = new TreeNode(8);
        cur = cur.right;
        cur.left = new TreeNode(4);
        System.out.println(new Solution().goodNodes(root));
    }
}