package com.ds.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    Stack<Integer> polishStack = new Stack<>();
    public int evalRPN(String[] tokens) {
        for(String token  : tokens) {
           if(isValidOperator(token)) {
               int r = polishStack.pop();
               int l = polishStack.pop();
               int v = performOperation(l,r, token);
               polishStack.push(v);
           } else {
               polishStack.push(Integer.parseInt(token));
           }
        }
        if(polishStack.size()==1) {
            return polishStack.pop();
        } else {
            System.out.println("Some issue");
            return -1;
        }
    }

    private boolean isValidOperator(String token) {
        String[] validOperations = new String[] {"+", "-", "/", "*"};
        return List.of(validOperations).contains(token);
    }

    private int performOperation(int l, int r, String token) {
        switch (token) {
            case "+":
                return l + r;
            case "-":
                return l - r;
            case "*":
                return l * r;
            case "/":
                return l / r;
            default:
                System.out.println("Operator not supported");
                return 0;
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        System.out.println(rpn.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(rpn.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(rpn.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));


    }
}
