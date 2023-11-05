package com.ds.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class LongestOfSubsString {
    public static void main(String[] args) {
        LongestOfSubsString lss = new LongestOfSubsString();
        System.out.println(lss.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lss.lengthOfLongestSubstring("dvdf"));
        System.out.println(lss.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lss.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> al = new ArrayList<>();
        int max = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int index = al.indexOf(aChar);
            if (index > -1) {
                max = Math.max(max, al.size());
                for (int i = 0; i <= index; i++) {
                    al.remove(0);
                }
            }
            al.add(aChar);
        }
        max = Math.max(max, al.size());
        return max;
    }
}
