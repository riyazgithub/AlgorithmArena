package com.heap;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((i1, i2) -> (i2-i1));
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size() < maxHeap.size())
        {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size())
            return minHeap.peek();
        return  (minHeap.peek() + maxHeap.peek()) * 0.5;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        int[] inputs = new int[] {41, 35, 62, 4, 97 , 108};
        for(int input  : inputs) {
            mf.addNum(input);
        }
        System.out.println("Median " + mf.findMedian());
    }
}
