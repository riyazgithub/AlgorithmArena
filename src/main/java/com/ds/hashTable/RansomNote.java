package com.ds.hashTable;

import java.util.HashMap;

/**
 * 383 Leetcode RansomNote
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rarr = ransomNote.toCharArray();
        char[] marr = magazine.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c : marr){
            int count = hm.getOrDefault(c, 0);
            hm.put(c,count +1);
        }
        for(char c : rarr){
            int count = hm.getOrDefault(c,0);
            if(count < 1) {
                return false;
            }
            hm.put(c,count -1);
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("a", "b"));
        System.out.println(rn.canConstruct("aa", "ab"));
        System.out.println(rn.canConstruct("aa", "aab"));
    }
}
