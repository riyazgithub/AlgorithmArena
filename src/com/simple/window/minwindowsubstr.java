package com.simple.window;

import java.util.HashMap;
import java.util.Map;


/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 */
public class minwindowsubstr {
    public String minWindow(String actualString, String subString) {
        // Create a character frequency map for characters in string 'subString'
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : subString.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        // Initialize variables
        int requiredCharacters = subString.length(); // Number of characters required to form the window
        int windowStart = 0; // Start index of the window
        int windowEnd = 0; // End index of the window
        int minWindowLength = Integer.MAX_VALUE; // Length of the minimum window found
        int minWindowStart = 0; // Start index of the minimum window found

        while (windowEnd < actualString.length()) {
            char currentChar = actualString.charAt(windowEnd);
            if (charFrequencyMap.containsKey(currentChar)) {
                // Decrease the frequency of the character and check if it's a required character
                if (charFrequencyMap.get(currentChar) > 0) {
                    requiredCharacters--;
                }
                charFrequencyMap.put(currentChar, charFrequencyMap.get(currentChar) - 1);
            }
            windowEnd++;

            while (requiredCharacters == 0) {
                // Update the minimum window length and start index if a smaller window is found
                if (windowEnd - windowStart < minWindowLength) {
                    minWindowLength = windowEnd - (minWindowStart = windowStart);
                }

                char startChar = actualString.charAt(windowStart);
                if (charFrequencyMap.containsKey(startChar)) {
                    // Increase the frequency of the character and check if it's a required character again
                    charFrequencyMap.put(startChar, charFrequencyMap.get(startChar) + 1);
                    if (charFrequencyMap.get(startChar) > 0) {
                        requiredCharacters++;
                    }
                }
                windowStart++;
            }
        }

        // Return the minimum window found
        return minWindowLength == Integer.MAX_VALUE ? "" : actualString.substring(minWindowStart, minWindowStart + minWindowLength);
    }

}
