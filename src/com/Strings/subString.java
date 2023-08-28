package com.Strings;

import java.util.Arrays;

public class subString {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            int left = i;
            int right = i;
            while(left >= 0 && s.charAt(left) == c) left --;
            while(right < s.length() && s.charAt(right) == c) right ++;
            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) != s.charAt(right)) break;
                left --;
                right ++;
            }
            left += 1;
            if(end - start < right - left) {
                start = left;
                end = right;
            }
        }
        String subStr = s.substring(start, end);
        System.out.println(String.format("I %s , J %s, %s is a palindrome", start , end , subStr));
        return subStr;
    }
    public String longestPalindromeMine(String s) {
        String longString = new String();
        if(s.isEmpty())
            return longString;
        char[] chars = s.toCharArray();
        for(int i = 0; i<chars.length; i++) {
            int j = chars.length-1;
            while (j>i) {
                if(chars[i] == chars[j])
                {
                    System.out.println(String.format("I %s , J %s", i , j ));
                    if(checkIfPalidrome(chars, i, j))
                    {
                        char[] substring = Arrays.copyOfRange(chars, i, j+1);
                        String result = new String(substring);
                        System.out.println(String.format("I %s , J %s, %s is a palindrome", i , j , result));
                        return result;
                    }
                    break;
                }
                j--;
            }

        }
        return longString;
    }

    private boolean checkIfPalidrome(char[] chars, int i, int j) {
        while(i > j) {
            if(chars[i] != chars[j])
                return false;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        subString ss = new subString();
        ss.longestPalindromeMine("babad");
        ss.longestPalindrome("babad");
        ss.longestPalindrome("acdefg");
    }
}
