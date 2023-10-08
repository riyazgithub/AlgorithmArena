package com.ds.List;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, DListNode> hm = new HashMap<>();
    DListNode head;
    DListNode end;
    int maxCapacity =0;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        head = new DListNode(-1,-1);
        end = new DListNode(-1,-1);
        head.next = end;
        end.prev = head;
    }

    public int get(int key) {
        if(!hm.containsKey(key))
        {
            System.out.println("Nothing to return -1");
            return -1;
        }
        DListNode curr = hm.get(key);
        remove(curr);
        insertAtEnd(curr);
        System.out.println("Get Returns "+ curr.val);
        return curr.val;
    }

    public void put(int key, int value) {
        // handle if the node already exists
        if(hm.containsKey(key)) {
            DListNode oldNode = hm.get(key);
            remove(oldNode);
        }
        DListNode curr = new DListNode(value, key);
        hm.put(key, curr);
        insertAtEnd(curr);
        if(hm.size()>maxCapacity)
        {
            System.out.println("Reached Max capacity remove node from begining");
            DListNode deleteNode = head.next;
            remove(deleteNode);
            hm.remove(deleteNode.key);
        }
    }

    public void remove(DListNode curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    public void insertAtEnd(DListNode curr) {
        DListNode pr = this.end.prev;
        pr.next = curr;
        curr.prev = pr;
        curr.next = end;
        end.prev = curr;
    }

    public static void main(String[] args) {
        //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]

        LRUCache lru = new LRUCache(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.head.printList();
        lru.put(4,4);
        lru.head.printList();
        lru.get(4);
//        lru.head.printList();
        lru.get(3);
//        lru.head.printList();
        lru.get(2);
//        lru.head.printList();
        lru.get(1);
//        lru.head.printList();
        lru.put(5,5);
        lru.head.printList();
        lru.get(1);
//        lru.head.printList();
        lru.get(2);
//        lru.head.printList();
        lru.get(3);
//        lru.head.printList();
        lru.get(4);
//        lru.head.printList();
        lru.get(5);
        lru.head.printList();

    }
}
