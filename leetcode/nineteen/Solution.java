//题目：leetcode19，给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//思路：快慢指针法
package nineteen;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick = head, slow = head;
        for(int i = 0; i < n; ++i)
        {
            quick = quick.next;
        }

        if (null == quick)
        {
            head = head.next;
            return head;
        }

        while (null != quick.next)
        {
            slow = slow.next;
            quick = quick.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}