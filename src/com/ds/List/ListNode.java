package com.ds.List;

public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void printList() {
              ListNode head = this;
        System.out.println("Begin === ");
        while (head != null) {
            System.out.print(head.val+ " ");
            head = head.next;
        }
        System.out.println(" ==  End");
    }
}
