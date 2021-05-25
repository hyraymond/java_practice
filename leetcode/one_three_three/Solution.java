package one_three_three;
//Clone Graph, question reference: https://leetcode-cn.com/problems/clone-graph/
//Use data structure hashmap, API reference: https://blog.csdn.net/wdays83892469/article/details/79615609
//Use data structure hashset, API reference: https://www.cnblogs.com/qilin20/p/12300384.html
import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    private HashMap<Node, Node> isVisited = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return node;
        }

        if(isVisited.containsKey(node))
        {
            return isVisited.get(node);
        }

        Node new_node = new Node(node.val, new ArrayList<Node>());
        isVisited.put(node, new_node);
        
        for (Node T: node.neighbors)
        {
            new_node.neighbors.add(cloneGraph(T));
        }

        return new_node;
    }
}
