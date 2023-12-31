package com.ds.stack;

/**
 * longest paranthesis ebay interview
 */

        import java.util.*;

/**
 Question : Given a string containing just the characters '(' and ')', print the longest valid parentheses (substring) from the input string.

 Forexample:
 Input: s = "(()"
 Output: ()
 Explanation: The longest valid parentheses substring is "()".

 Forexample:
 Input: s = ")()())"
 Output: ()()
 Explanation: The longest valid parentheses substring is "()()".

 Forexample:
 Input: s = "(())((((())))"
 Output: (((())))
 Explanation: There are two groups here that are valid, the longest valid parentheses substring is "(((())))".

 print longest valid substring
 (()))()()()


 */

// Main class should be named 'Solution' and should not be public.
class stackLongParanthesis {

    public String longestValidParantheses_(String input) {
        Stack<Character> pStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int startIndex = -1; int endIndex =-1;
        // validate

        char[] inputArr = input.toCharArray();
        int temp = 0;
        for(int index = 0; index < inputArr.length; index++) {
            temp = -1;
            if(inputArr[index] == '(') {
                pStack.push(inputArr[index]);
                indexStack.push(index);

            } else if(inputArr[index] == ')') {
                if(pStack.isEmpty()) {
                    // invalid string ignore.

                }  else if (pStack.peek() == '('){
                    // System.out.println(" Stack size " + pStack.size());
                    pStack.pop();
                    temp = indexStack.pop();
                }
            }

            if((temp !=-1 && (index -temp) > (endIndex - startIndex))) {
                if(pStack.isEmpty()) { startIndex = temp;}
                endIndex = index;

            }
        }
        System.out.println("Start "+startIndex+" End "+endIndex);
        if( startIndex != -1 && endIndex != -1)
            return input.substring(startIndex, endIndex+1);
        return "";
    }

    public String longestValidParantheses(String input) {
        Stack<Integer> stack= new Stack<>();
        char[] chars = input.toCharArray();
        stack.push(-1); int max =0, p1=0,p2=0;
        for (int i =0; i < chars.length; i++){
            if(chars[i] == '(')
                stack.push(i);
            else if(chars[i] == ')') {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else {
                    if(max < i - stack.peek()) {
                        p1 = stack.peek();
                        p2 = i;
                         max = i - stack.peek();
                    }
                }
            }
        }
        System.out.println("Max len "+max);
        System.out.println(String.format("Input: %s, New Max %s , start %s , End %s, substring %s", input, max, p1, p2, input.substring(p1+1,p2+1)));
        return (max==0) ? "": input.substring(p1+1,p2+1);
    }

    public static void main(String[] args) {
        System.out.println("Hello, World");

        stackLongParanthesis s = new stackLongParanthesis();
        System.out.println(s.longestValidParantheses(")()(()())("));
        System.out.println(s.longestValidParantheses(")()())"));
        System.out.println(s.longestValidParantheses("(())((((())))"));

    }
}
