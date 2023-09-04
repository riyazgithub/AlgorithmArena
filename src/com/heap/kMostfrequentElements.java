package com.heap;

import java.awt.image.ImageProducer;
import java.util.*;


public class kMostfrequentElements {

    public int[] topKFrequent_naive(int[] nums, int k) {
        int[] returnA = new int[k];
        HashMap<Integer, Integer> haveCount = new HashMap<>();
        for (int num : nums) {
            int count = haveCount.getOrDefault(num, 0);
            haveCount.put(num, count + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return haveCount.get(o1) - haveCount.get(o2);
            }
        });

        for(Map.Entry<Integer, Integer> me : haveCount.entrySet()) {
            maxHeap.offer(me.getKey());
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        for (int i =0 ; i<k; i++) returnA[i] = maxHeap.poll();
        return returnA;
    }

    public static void main(String[] args) {
        kMostfrequentElements km = new kMostfrequentElements();
        int[] nums = {1, 1, 1,1,2,1,2,1,2,4, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(km.topKFrequent_naive(nums, k)));
    }
}
