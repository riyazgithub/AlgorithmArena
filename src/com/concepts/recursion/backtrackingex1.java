package com.concepts.recursion;

public class backtrackingex1 {

    /**
     * Let's take a simple example: Generating all binary strings of length n.
     * @param args
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
      genaratebinString("", 3);
    }

    private static void genaratebinString(String  sb, int len) {
        if(sb.length() == len) {
            System.out.println(sb);
            return;
        }
        genaratebinString(sb+"0", len);
        genaratebinString(sb+"1", len);
    }
}
