package com.List;

import java.util.Stack;

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

    public boolean isPalindrome(ListNode head) {
        if(head!=null)
            return checkPalindrome(head);
        return false;
    }

    private boolean checkPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode curr =head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.val != stack.pop()) return false;
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // Creating nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(2);
        ListNode node10 = new ListNode(1);

        // Connecting nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        linkedList ll =new linkedList();
        node1.printList();
        ListNode rev = ll.reverseList(node1);
        rev.printList();
        System.out.println(" Is it Palindrome "+ ll.isPalindrome(rev));
    }
}
