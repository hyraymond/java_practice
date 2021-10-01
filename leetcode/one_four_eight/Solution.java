package one_four_eight;
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
//     private ListNode mergeSort(ListNode lh, ListNode rh)
//     {
//         ListNode head = new ListNode();
//         ListNode cur = head;
//         int a = lh == null? Integer.MAX_VALUE: lh.val;
//         int b = rh == null? Integer.MAX_VALUE: rh.val;
//         while (lh != null && rh != null)
//         {
//             ListNode next = new ListNode();
//             if (a < b)
//             {
//                 next.val = a;
//                 lh = lh.next;
//             }
//             else
//             {
//                 next.val = b;
//                 rh = rh.next;
//             }
//             cur.next = next;
//             cur = next;
//             a = lh == null? Integer.MAX_VALUE: lh.val;
//             b = rh == null? Integer.MAX_VALUE: rh.val;
//         }
//         if (rh == null)
//         {
//             cur.next = lh;
//         }
//         else 
//         {
//             cur.next = rh;
//         }
//         return head.next;
//     }
//     public ListNode sortList(ListNode head) {
//         if (head == null || head.next == null)
//         {
//             return head;
//         }
//         ListNode slow = head;
//         ListNode fast = slow;
//         ListNode prev = head;
//         while (fast != null && fast.next != null)
//         {
//             prev = slow;
//             slow = slow.next;
//             fast = fast.next;
//             if (fast != null)
//             {
//                 fast = fast.next;
//             }
//         }
//         prev.next = null;

//         // System.out.println(head.val + " " + slow.val);
//         ListNode lh = sortList(head);
//         ListNode rh = sortList(slow);
//         // System.out.println(lh.val + " " + rh.val);
//         return mergeSort(lh, rh);
//     }
// }