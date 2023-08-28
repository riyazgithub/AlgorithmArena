package com.array;

import java.util.Stack;

public class makeValidParanthesis {

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        if(s.isEmpty())
            return sb.toString();
        char[] chars = s.toCharArray();
        for(int i =0; i< chars.length;i++) {
            if (Character.isLetter(chars[i]))
                continue;
            if (chars[i] == '(')
                stk.push(i);
            else if (!stk.isEmpty() && chars[stk.peek()] == '(') {
                stk.pop();
            } else stk.push(i);
        }
            for(int i =0; i< chars.length;i++) {
             if(!stk.contains(i)) {
                 sb.append(chars[i]);
             }
            }
        return sb.toString();
    }

    public static void main(String[] args) {
        makeValidParanthesis mkae = new makeValidParanthesis();
        System.out.println(mkae.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(mkae.minRemoveToMakeValid("))(("));

    }
}
