package com.ds.stack;

import java.util.Stack;

public class QueueUsingStacks {

    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    Stack<Integer> s1;
    Stack<Integer> s2;
    public void push(int x) {
        reBalanceStackS1();
        s1.push(x);
    }

    public int pop() {
        reBalanceStack();
        return s2.pop();
    }

    public int peek() {
        reBalanceStack();
        return s2.peek();
    }

    private void reBalanceStack() {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
//        System.out.println("Re balance done s2!");
    }

    private void reBalanceStackS1() {
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
//        System.out.println("Re balance done S1!");
    }

    public boolean empty() {
        reBalanceStack();
        return s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks qs = new QueueUsingStacks();
        qs.push(1);
        qs.push(2);
        qs.push(3);
        qs.push(4);
        System.out.println("Peek "+qs.peek());
        System.out.println("Pop "+qs.pop());
        qs.push(5);
        System.out.println("Pop "+qs.pop());
        System.out.println("Pop "+qs.pop());
        System.out.println("Pop "+qs.pop());
        System.out.println("Pop "+qs.pop());
        System.out.println("Is Empty "+qs.empty());
    }
}
