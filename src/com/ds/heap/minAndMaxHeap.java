package com.ds.heap;

import java.util.*;
public class minAndMaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        pqMin.offer(10);
        pqMin.offer(3);pqMin.offer(1);pqMin.offer(2);
        System.out.println("Min Person "+pqMin.poll());

        PriorityQueue<Integer> pqMax = new PriorityQueue<>((i1, i2) -> i2 - i1);
        pqMax.offer(10);
        pqMax.offer(3);pqMax.offer(1);pqMax.offer(2);
        System.out.println("Max Person "+pqMax.poll());

    }
}
