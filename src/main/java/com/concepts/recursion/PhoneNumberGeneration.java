package com.concepts.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberGeneration {
    List<String> lc;
    public List<String> letterCombinations(String digits) {
        lc = new ArrayList<>();
        Map<String, String> numberToAlphabetMap = new HashMap<>();

        // Populate the map with number-to-alphabet mappings for digits 2 to 9
        numberToAlphabetMap.put("2", "abc");
        numberToAlphabetMap.put("3", "def");
        numberToAlphabetMap.put("4", "ghi");
        numberToAlphabetMap.put("5", "jkl");
        numberToAlphabetMap.put("6", "mno");
        numberToAlphabetMap.put("7", "pqrs");
        numberToAlphabetMap.put("8", "tuv");
        numberToAlphabetMap.put("9", "wxyz");
        if(digits!=null && digits.length() > 0) {
            letterCombinationsHelp(numberToAlphabetMap, digits.toCharArray(), new StringBuilder(""), 0);
        }
        return lc;

    }

    private void letterCombinationsHelp(Map<String, String> numberToAlphabetMap, char[] inputArr, StringBuilder sb, int index) {
        if(sb.length() == inputArr.length) {
            this.lc.add(new String(sb));
        }
        if(index >= inputArr.length)
            return;
        for(char c : numberToAlphabetMap.get(inputArr[index]+"").toCharArray()) {
            sb.append(c);
            letterCombinationsHelp(numberToAlphabetMap, inputArr, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {

        String input = new String("23");
        PhoneNumberGeneration png = new PhoneNumberGeneration();
        png.letterCombinations(input);
        System.out.println(png.lc);
    }
}
