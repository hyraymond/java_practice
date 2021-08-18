package five_four_three;

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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return result;
    }
    private int getDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int a = getDepth(root.left);
        int b = getDepth(root.right);
        int c = a + b ;
        result = result < c? c: result;
        return Math.max(a, b) + 1;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode cur = root.left;
        cur.left = new TreeNode(4);
        cur.right = new TreeNode(5);
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}