package two_zeo_six;
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
//     public ListNode reverseList(ListNode head) {
//         if (null == head)
//         {
//             return head;
//         }
        
//         ListNode cur = head;
//         ListNode next = head.next;
//         ListNode prev = head;
//         cur.next = null;

//         while(next != null)
//         {
//             prev = cur;
//             cur = next;
//             next = next.next;
//             cur.next = prev;
//         }
//         return cur;
//     }
// }
