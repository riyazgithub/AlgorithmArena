package com.List;

public class linkedList {

    public ListNode reverseList(ListNode head) {
        if (head== null)
            return head;
        ListNode curr = head;
        ListNode p = null;
        ListNode n = curr.next;
        while (curr.next!=null) {
            curr.next =p;
            p=curr;
            curr = n;
            n=curr.next;
        }
        curr.next=p;
        return curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2,head);
        ListNode n2 = new ListNode(3,n1);
        ListNode n3 = new ListNode(4,n2);
        n3.printList();
        linkedList ll =new linkedList();
        ListNode rev = ll.reverseList(n3);
        rev.printList();

    }
}
