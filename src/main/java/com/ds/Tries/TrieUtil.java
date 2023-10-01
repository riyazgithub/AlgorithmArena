package com.ds.Tries;

public class TrieUtil {
    public static void main(String[] args) {
        TrieNode tn = new TrieNode();
        tn.insert("riyaz");
        tn.insert("ramya");
        System.out.println(tn);
        System.out.println(tn.search("riyaz"));
        System.out.println(tn.search("ri1"));
        System.out.println(tn.startsWith("ri"));
        System.out.println(tn.startsWith("ry"));
    }
}
