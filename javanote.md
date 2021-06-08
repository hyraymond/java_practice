# Java Notebook
## 2021/06/08
### B Tree
* Definition: a B-tree is an empty tree or a B-tree of order m satisfies the following things:
   1. Every node has at most m children.
   2. Every non-leaf node (except root) has at least $ \lceil m/2 \rceil$ child nodes.
   3. The root has at elast two children if it is not a leaf node.
   4. A non-leaf node with k children contains k-1 keys.
   5. All leaves appear in the same level and carry no information.

B-tree and B+ tree, reference: https://my.oschina.net/u/4116286/blog/3107389