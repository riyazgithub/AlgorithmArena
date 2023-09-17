package com.concepts.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CollectionModifier {
    private static List<Integer> collection = new ArrayList<>();
    private static int addCount = 0;
    private static int removeCount = 0;
    private static final int MAX_COUNT = 20;

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        // Schedule a task to add elements to the collection every one minute
        executorService.scheduleAtFixedRate(() -> {
            if (addCount < MAX_COUNT) {
                int elementToAdd = (int) (Math.random() * 100);
                addElement(elementToAdd);
                addCount++;
            } else {
                executorService.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);

        // Schedule a task to remove elements from the collection every one minute
        executorService.scheduleAtFixedRate(() -> {
            if (removeCount < MAX_COUNT) {
                if (!collection.isEmpty()) {
                    int indexToRemove = (int) (Math.random() * collection.size());
                    removeElement(indexToRemove);
                    removeCount++;
                }
            } else {
                executorService.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    private static synchronized void addElement(int element) {
        collection.add(element);
        System.out.println("Added element: " + element + ", Collection size: " + collection.size());
    }

    private static synchronized void removeElement(int index) {
        if (index >= 0 && index < collection.size()) {
            int removedElement = collection.remove(index);
            System.out.println("Removed element: " + removedElement + ", Collection size: " + collection.size());
        }
    }
}


