package com.concepts.simple.standalone;

import java.util.Arrays;
import java.util.HashSet;

public class CollectionManipulation {
    public static void main(String[] args) {
        String commaSeparated = "apple,banana,orange";

        HashSet<String> set = new HashSet<>(Arrays.asList(commaSeparated.split(",")));

        System.out.println(set);

        commaSeparated = "apple";
        set = new HashSet<>(Arrays.asList(commaSeparated.split(",")));
        System.out.println(set);
    }
}
