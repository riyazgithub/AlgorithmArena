package com.ds.List;

public class DListNode {
    int val;
    int key;
    DListNode next;
    DListNode prev;
    DListNode() {}
    DListNode(int val, int key) { this.val = val; this.key = key;}
    DListNode(int val, DListNode next) { this.val = val; this.next = next; }
    public void printList() {
        DListNode head = this;
        System.out.println("Begin === ");
        while (head != null) {
            System.out.print(head.val+ " ");
            head = head.next;
        }
        System.out.println(" ==  End");
    }
}
