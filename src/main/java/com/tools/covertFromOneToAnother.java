package com.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class covertFromOneToAnother {
    public static void main(String[] args) {
        // Create a Set

    }

    public void convertArrayListIntegerToArray() {
        List<Integer> convert = new ArrayList<>();
        // Sample data for testing
        convert.add(1);
        convert.add(2);
        convert.add(3);
        convert.add(4);

        int[] nums = new int[convert.size()];
        for (int i = 0; i < convert.size(); i++) {
            nums[i] = convert.get(i);
        }

        // Print the array for verification
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void printListOfList(List<List<Integer>> printList){
        System.out.println("Size of List of Lists: " + printList.size());

        for (int i = 0; i < printList.size(); i++) {
            System.out.println("List " + (i + 1) + ":");
            List<Integer> innerList = printList.get(i);

            for (int j = 0; j < innerList.size(); j++) {
                System.out.print(innerList.get(j) + ", ");
            }
            System.out.println();
        }
    }
    public void convertHashSetToArrayList() {
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(1);
        numberSet.add(2);
        numberSet.add(3);
        numberSet.add(4);
        numberSet.add(5);

        // Convert Set to List
        List<Integer> numberList = new ArrayList<>(numberSet);
        // Print the List
        System.out.println("List: " + numberList);
    }

}
