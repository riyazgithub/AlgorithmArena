package com.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class covertFromOneToAnother {
    public static void main(String[] args) {
        // Create a Set
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
