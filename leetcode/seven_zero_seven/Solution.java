package seven_zero_seven;
// Implement a Linked List, reference: https://leetcode-cn.com/problems/design-linked-list/
class Node{
    Node next;
    Node prev;
    int val;
    Node()
    {
        next = this;
        prev = this;
    }
}
class MyLinkedList {
    Node head;
    Node tail;
    int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= length)
        {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i < index; ++i)
        {
            cur = cur.next;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node();
        cur.val = val;
        if (length == 0)
        {
            head = cur;
            tail = cur;
        }
        else
        {
            cur.prev = tail;
            tail.next = cur;
            cur.next = head;
            head.prev = cur;
            head = cur;
        }
        ++length;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtHead(val);
        tail = tail.next;
        head = head.next;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length)
        {
            return;
        }
        if (index == 0)
        {
            addAtHead(val);
        }
        else if (index == length)
        {
            addAtTail(val);
        }
        else
        {
            Node cur = new Node();
            cur.val = val;
            Node in = head;
            for(int i = 1; i < index; ++i)
            {
                in = in.next;
            }
            cur.next = in.next;
            in.next.prev = cur;
            in.next = cur;
            cur.prev = in;
            ++length;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (length == 0 || index >= length)
        {
            return ;
        }
        if (index == 0)
        {
            tail.next = head.next;
            head.next.prev = tail;
            head = head.next;
            --length;
        }
        else if (index == length - 1)
        {
            head.prev = tail.prev;
            tail.prev.next = head;
            tail = head.prev;
            --length;
        }
        else
        {
            Node cur = head;
            for (int i = 0; i < index; ++i)
            {
                cur = cur.next;
            }
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            --length;
        }
    }
    void print()
    {
        int n = length;
        Node cur = head;
        for (int i = 0; i < n; ++i)
        {
            System.out.print(cur.val);
            cur = cur.next;
        }
        System.out.println(" ");
    }
    public static void main(String[] args)
    {
        MyLinkedList k = new MyLinkedList();
        k.addAtHead(1);
        k.addAtHead(2);
        k.addAtHead(3);
        k.addAtTail(4);
        k.addAtTail(5);
        k.print();
        System.out.println(k.get(0));
        System.out.println(k.get(4));
        System.out.println(k.get(5));
        k.addAtIndex(0, 6);
        k.print();
        k.addAtIndex(1, 7);
        k.print();
        k.addAtIndex(6, 8);
        k.print();
        k.addAtIndex(8, 9);
        k.print();
        k.deleteAtIndex(0);
        k.print();
        k.deleteAtIndex(3);
        k.print();
        k.deleteAtIndex(6);
        k.print();
        k.deleteAtIndex(6);
        k.print();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
