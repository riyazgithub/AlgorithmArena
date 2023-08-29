package com.stringsmanipulation;

import java.util.Stack;

/**
 * Example 1:
 * <p>
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * <p>
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * <p>
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s1 = "3[a2[c]]";
        String s2 = "2[abc]3[cd]ef";
        DecodeString ds = new DecodeString();
//        System.out.println(String.format("Decoded String %s encoded String %s", s,ds.decodeString(s)));
        System.out.println(String.format("Decoded String %s encoded String %s", s1,ds.decodeString(s1)));
        System.out.println(String.format("Decoded String %s encoded String %s", s2,ds.decodeString(s2)));
    }

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> ssb = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int count =0;
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                if(count > 0)
                    count *= 10;
                count += Character.getNumericValue(c);
            } else if(c == '[') {
                ssb.push(stringBuilder);
                numStack.push(count);
                stringBuilder = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder temp = stringBuilder;
                stringBuilder = ssb.pop();
                int num = numStack.pop();
                while (num-- > 0) {
                    stringBuilder.append(temp);
                }
            }else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
    public String decodeString_old(String s) {
        StringBuilder main = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();
        if (s.isEmpty())
            return s;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ']') {
                characterStack.push(chars[i]);
            } else{
                int count = 0;
                StringBuilder temp2 = new StringBuilder();
                while (Character.isAlphabetic(characterStack.peek())){
                    temp2.append(characterStack.pop());
                }
                if (temp2.length() > 0) {
                    temp.append(temp2.reverse().toString());
                }
                if (characterStack.peek() == '[')
                    characterStack.pop();
                if (Character.isDigit(characterStack.peek())) {
                    count = Character.getNumericValue(characterStack.pop());
                    String copy = temp.toString();
                    while (count > 1) {
                        temp.append(copy);
                        count--;
                    }
                }
                if (characterStack.isEmpty()) {
                    main.append(temp);
                    temp = new StringBuilder();
                }
            }
        }
        return main.toString();
    }
}
