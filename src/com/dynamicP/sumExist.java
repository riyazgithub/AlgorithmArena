package com.dynamicP;

import java.util.HashMap;


public class sumExist {

    // Solution 1: Brute force
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    // n = number of elements in the array


    public static boolean canPartition(int[]num, HashMap<Integer, Integer> map)
    {
        for(int i : num) {
            int count = map.getOrDefault(i, 0);
            if(count > 0) {
                map.put(i, count - 1);
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        int[] set = {1, 2,3,4};
        int[][] subSet = {{1,2}, {3,1}};
        HashMap <Integer, Integer> map = new HashMap<>();
        populateMap(set, map);
        boolean result  = true;
        for(int[] sub : subSet) {
            result = result && canPartition(sub, map);
            if(!result)
                break;
        }
        System.out.println("Can Partition ? "+ result);
    }

    private static void populateMap(int[] set, HashMap<Integer, Integer> map) {
        for (int i = 0; i < set.length; i++) {
            Integer count = map.getOrDefault(set[i], 0);
            count++;
            map.put(set[i], count);
        }
    }

    private static boolean isSubset(int[] subset, int[] set) {
        return false;
    }
}
