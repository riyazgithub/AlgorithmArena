package com.concepts.simple.standalone;

import java.util.*;

public class CollectionsCRUD {

    // ArrayList
    List<String> arrayList = new ArrayList<>();

    // LinkedList
    List<String> linkedList = new LinkedList<>();

    // HashSet
    Set<String> hashSet = new HashSet<>();

    // LinkedHashSet
    Set<String> linkedHashSet = new LinkedHashSet<>();

    // TreeSet
    Set<String> treeSet = new TreeSet<>();

    // PriorityQueue
    Queue<String> priorityQueue = new PriorityQueue<>();

    // ArrayDeque
    Deque<String> arrayDeque = new ArrayDeque<>();

    // HashMap
    Map<String, String> hashMap = new HashMap<>();

    // LinkedHashMap
    Map<String, String> linkedHashMap = new LinkedHashMap<>();

    // TreeMap
    Map<String, String> treeMap = new TreeMap<>();

    // Create operations
    public void create(String element) {
        arrayList.add(element);
        linkedList.add(element);
        hashSet.add(element);
        linkedHashSet.add(element);
        treeSet.add(element);
        priorityQueue.offer(element);
        arrayDeque.offer(element);
        hashMap.put(element, element);
        linkedHashMap.put(element, element);
        treeMap.put(element, element);
    }

    // Read operations
    public void read() {
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("ArrayDeque: " + arrayDeque);
        System.out.println("HashMap: " + hashMap);
        System.out.println("LinkedHashMap: " + linkedHashMap);
        System.out.println("TreeMap: " + treeMap);
    }

    // Update operations (where applicable)
    public void update(String oldElement, String newElement) {
        if (arrayList.contains(oldElement)) {
            arrayList.set(arrayList.indexOf(oldElement), newElement);
        }
        // LinkedList does not have a direct method for replacing
        if (linkedList.contains(oldElement)) {
            linkedList.set(linkedList.indexOf(oldElement), newElement);
        }
        if (hashSet.contains(oldElement)) {
            hashSet.remove(oldElement);
            hashSet.add(newElement);
        }
        // Similar for LinkedHashSet and TreeSet
        if (linkedHashSet.contains(oldElement)) {
            linkedHashSet.remove(oldElement);
            linkedHashSet.add(newElement);
        }
        if (treeSet.contains(oldElement)) {
            treeSet.remove(oldElement);
            treeSet.add(newElement);
        }
        // Queues and Deques generally don't have update operations

        // Maps
        if (hashMap.containsKey(oldElement)) {
            hashMap.put(oldElement, newElement);
        }
        if (linkedHashMap.containsKey(oldElement)) {
            linkedHashMap.put(oldElement, newElement);
        }
        if (treeMap.containsKey(oldElement)) {
            treeMap.put(oldElement, newElement);
        }
    }

    // Delete operations
    public void delete(String element) {
        arrayList.remove(element);
        linkedList.remove(element);
        hashSet.remove(element);
        linkedHashSet.remove(element);
        treeSet.remove(element);
        priorityQueue.remove(element);
        arrayDeque.remove(element);
        hashMap.remove(element);
        linkedHashMap.remove(element);
        treeMap.remove(element);
    }

    public static void main(String[] args) {
        CollectionsCRUD crud = new CollectionsCRUD();

        // Create elements
        crud.create("Element1");
        crud.create("Element2");

        // Read elements
        crud.read();

        // Update elements
        crud.update("Element1", "UpdatedElement1");

        // Delete elements
        crud.delete("Element2");

        // Read elements again to see the updates
        crud.read();
    }
}

