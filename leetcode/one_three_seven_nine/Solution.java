package one_three_seven_nine;

import java.util.*;
//  * Definition for a binary tree node.
class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode(int x) { val = x; }
}

public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode cur = original;
        TreeNode clone = cloned;
        Queue<TreeNode> cur_s = new LinkedList<TreeNode>();
        Queue<TreeNode> clone_s = new LinkedList<TreeNode>();
        cur_s.add(cur);
        clone_s.add(clone);

        while(!cur_s.isEmpty())
        {
            cur = cur_s.peek();
            clone = clone_s.peek();

            if (target == cur)
            {
                return clone;
            }
            cur_s.poll();
            clone_s.poll();
            if(cur != null)
            {
                cur_s.add(cur.left);
                cur_s.add(cur.right);
                clone_s.add(clone.left);
                clone_s.add(clone.right);
            }
            
        }
        return null;

    }
}
