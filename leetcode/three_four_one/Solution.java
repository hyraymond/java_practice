package three_four_one;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// public class NestedIterator implements Iterator<Integer> {
//     List<Integer> list;
//     Iterator<Integer> it;
//     public NestedIterator(List<NestedInteger> nestedList) {
//         list = new ArrayList<Integer>();
//         dfs(nestedList);
//         it = list.iterator();
//     }

//     @Override
//     public Integer next() {
//         return it.next();
//     }

//     @Override
//     public boolean hasNext() {
//         return it.hasNext();
//     }

//     void dfs(List<NestedInteger> nestedList){
//         NestedInteger temp = null;
//         Iterator<NestedInteger> p = nestedList.iterator();
//         while(p.hasNext()){
//             temp = p.next();
//             if (temp.isInteger()){
//                 list.add(temp.getInteger());
//             }
//             else{
//                 dfs(temp.getList());
//             }
//         }
//     }
// }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
