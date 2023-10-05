package com.concepts.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 *
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 *
 * Return a list of all possible strings we could create. Return the output in any order.
 */
public class letterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        List<String> permute = new ArrayList<>();
        List<String> re = new ArrayList<>();
//        lcPermuteHelp(s.toCharArray(),permute);
        lcPermuteHelpRecur(s.toCharArray(),permute, new StringBuilder(), 0);
//        for (StringBuilder p :permute) {
//            re.add(p.toString());
//        }
        return permute;
    }

    private void lcPermuteHelpRecur(char[] charArray, List<String> permute, StringBuilder slate, int index) {
        if(slate.length() == charArray.length)
        {
            permute.add(new String(slate));
            return;
        }
        char c = charArray[index];
        if(Character.isAlphabetic(c)) {
            lcPermuteHelpRecur(charArray, permute, slate.append(Character.toLowerCase(c)), index +1 );
            slate.deleteCharAt(slate.length()-1);
            lcPermuteHelpRecur(charArray, permute, slate.append(Character.toUpperCase(c)), index +1 );
            slate.deleteCharAt(slate.length()-1);
        } else {
            lcPermuteHelpRecur(charArray, permute, slate.append(c), index +1 );
            slate.deleteCharAt(slate.length()-1);
        }
    }

    private void lcPermuteHelp(char[] charArray, List<StringBuilder> permute) {
        permute.add(new StringBuilder());
        for(char c : charArray) {
            int size = permute.size();
            if(Character.isAlphabetic(c)) {
                for(int i =0; i<size; i++ ) {
                    permute.add(new StringBuilder(permute.get(i)));
                    permute.get(i).append(Character.toLowerCase(c));
                    permute.get(size + i).append(Character.toUpperCase(c));
                }
            } else {
                for(int i =0; i<size; i++ ) {
                    permute.get(i).append(c);
                }
            }
        }
    }

    public static void main(String[] args) {
        letterCasePermutation lcp = new letterCasePermutation();
        System.out.println(lcp.letterCasePermutation("a2b2c"));
    }
}
