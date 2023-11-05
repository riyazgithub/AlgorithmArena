package com.ds.List;

import java.util.PriorityQueue;

public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode h = new ListNode(0);
        ListNode ret = h;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode node : lists){
            ListNode curr = node;
            while(curr!=null){
                pq.add(curr);
                curr = curr.next;
            }
        }
        ListNode point = h;
        while (!pq.isEmpty()){
            ListNode curr = pq.poll();
            point.next = curr;
            curr.next = null;
            point = point.next;
        }
        return ret.next;
    }

    // Helper function to create a linked list from an array
    public static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 4, 5},
                {1, 3, 4},
                {2, 6}
        };

        ListNode[] lists = new ListNode[data.length];
        for (int i = 0; i < data.length; i++) {
            lists[i] = createLinkedList(data[i]);
        }

        MergeKList merge = new MergeKList();
        ListNode mergedList = merge.mergeKLists(lists);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.println("null");
    }
}
