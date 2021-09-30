package two_three;
import java.util.*;
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
//         int n = lists.length;
//         if (n == 0)
//         {
//             return null;
//         }
//         PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>(){
//             @Override
//             public int compare(Integer o1, Integer o2)
//             {
//                 if (lists[o1] == null && lists[o2] == null)
//                 {
//                     return 0;
//                 }
//                 else if (lists[o1] == null)
//                 {
//                     return 1;
//                 }
//                 else if (lists[o2] == null)
//                 {
//                     return -1;
//                 }
//                 return lists[o1].val - lists[o2].val;
//             }
//         });

//         ListNode head = new ListNode();
//         ListNode cur = head;
//         for (int i = 0; i < n; ++i)
//         {
//             q.add(i);
//         }

//         while (lists[q.peek()] != null)
//         {
//             int a = q.poll();
//             ListNode next = new ListNode(lists[a].val);
//             cur.next = next;
//             cur = next;
//             lists[a] = lists[a].next;
//             q.add(a);
//         }
//         return head.next;
//     }
// }
