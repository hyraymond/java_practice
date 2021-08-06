package August_6th;

import java.util.*;
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
class Nnode {
    public Node cur;
    public int color;
    public Nnode()
    {
        cur = null;
        color = 0;
    }
    public Nnode(Node node)
    {
        cur = node;
    }
    public Nnode(Node node, int node_color)
    {
        cur = node;
        color = node_color;
    }
}
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
        {
            return new ArrayList<List<Integer>>();
        }
        
        Queue<Nnode> tab = new LinkedList<Nnode>();
        Nnode temp = new Nnode(root);
        temp.color = 0;
        tab.add(temp);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> con = new ArrayList<Integer>();
        int cur_color = 0;
        while(!tab.isEmpty())
        {
            temp = tab.peek();
            if (temp.cur != root && temp.color != cur_color)
            {
                result.add(con);
                con = new ArrayList<Integer>();
                cur_color = temp.color;
            }
            con.add(temp.cur.val);
            for (Node p: temp.cur.children)
            {
                tab.add(new Nnode(p, cur_color + 1));
            }
            tab.poll();
        } 
        result.add(con);
        return result;
    }
}
