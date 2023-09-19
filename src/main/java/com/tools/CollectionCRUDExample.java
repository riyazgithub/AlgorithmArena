import java.util.*;

public class CollectionCRUDExample {

    // Create and perform CRUD operations on a PriorityQueue
    public static void priorityQueueExample() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Create
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(8);

        // Read
        System.out.println("PriorityQueue: " + priorityQueue);

        // Update (Not applicable for PriorityQueue)

        // Delete
        priorityQueue.poll();
        System.out.println("After deleting the top element: " + priorityQueue);
    }

    // Create and perform CRUD operations on a Stack
    public static void stackExample() {
        Stack<Integer> stack = new Stack<>();

        // Create
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Read
        System.out.println("Stack: " + stack);

        // Update (Not applicable for Stack)

        // Delete
        stack.pop();
        System.out.println("After popping the top element: " + stack);
    }

    // Create and perform CRUD operations on a Deque (LinkedList implementation)
    public static void dequeExample() {
        Deque<String> deque = new LinkedList<>();

        // Create
        deque.addFirst("First");
        deque.addLast("Last");

        // Read
        System.out.println("Deque: " + deque);

        // Update (Not applicable for Deque)

        // Delete
        deque.removeFirst();
        System.out.println("After removing the first element: " + deque);
    }

    // Create and perform CRUD operations on a LinkedList
    public static void linkedListExample() {
        LinkedList<String> linkedList = new LinkedList<>();

        // Create
        linkedList.add("Apple");
        linkedList.add("Banana");

        // Read
        System.out.println("LinkedList: " + linkedList);

        // Update
        linkedList.set(1, "Cherry");
        System.out.println("After updating the second element: " + linkedList);

        // Delete
        linkedList.removeFirst();
        System.out.println("After removing the first element: " + linkedList);
    }

    // Create and perform CRUD operations on a HashMap
    public static void hashMapExample() {
        Map<String, Integer> hashMap = new HashMap<>();

        // Create
        hashMap.put("One", 1);
        hashMap.put("Two", 2);

        // Read
        System.out.println("HashMap: " + hashMap);

        // Update
        hashMap.put("Two", 22);
        System.out.println("After updating the value for 'Two': " + hashMap);

        // Delete
        hashMap.remove("One");
        System.out.println("After removing the entry for 'One': " + hashMap);
    }

    // Create and perform CRUD operations on a TreeMap
    public static void treeMapExample() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Create
        treeMap.put("A", 10);
        treeMap.put("B", 20);

        // Read
        System.out.println("TreeMap: " + treeMap);

        // Update
        treeMap.put("B", 25);
        System.out.println("After updating the value for 'B': " + treeMap);

        // Delete
        treeMap.remove("A");
        System.out.println("After removing the entry for 'A': " + treeMap);
    }

    // Create and perform CRUD operations on a HashSet
    public static void hashSetExample() {
        Set<String> hashSet = new HashSet<>();

        // Create
        hashSet.add("Red");
        hashSet.add("Blue");

        // Read
        System.out.println("HashSet: " + hashSet);

        // Update (Not applicable for HashSet)

        // Delete
        hashSet.remove("Red");
        System.out.println("After removing 'Red': " + hashSet);
    }

    public static void main(String[] args) {
        System.out.println("PriorityQueue Example:");
        priorityQueueExample();

        System.out.println("\nStack Example:");
        stackExample();

        System.out.println("\nDeque Example:");
        dequeExample();

        System.out.println("\nLinkedList Example:");
        linkedListExample();

        System.out.println("\nHashMap Example:");
        hashMapExample();

        System.out.println("\nTreeMap Example:");
        treeMapExample();

        System.out.println("\nHashSet Example:");
        hashSetExample();
    }
}
