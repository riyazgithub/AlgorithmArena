package com.ds.Tries;

public class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public void insert(String word) {
        char[] c = word.toCharArray();
        TrieNode ctn = this;
        for(int i =0; i<c.length; i++) {
            if(!ctn.containsKey(c[i]))
            {
                insert_help(ctn,c,i);
                return;
            }
        }
        ctn.setEnd();
    }

    private void insert_help(TrieNode trieNode, char[] chars, int index) {
        if(index == chars.length){
            trieNode.setEnd();
            return;
        }
        trieNode.links[chars[index]- 'a'] = new TrieNode();
        insert_help(trieNode.links[chars[index]-'a'], chars, index+1);
        }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode ctn = this;
        if(chars.length == 0)
            return false;
        return search_help(ctn,0, chars);
    }

    private boolean search_help(TrieNode ctn, int i, char[] chars) {
        if(i >= chars.length){
            return ctn.isEnd();
        }
        if(ctn == null || !ctn.containsKey(chars[i])) {
            return false;
        }
        return search_help(ctn.get(chars[i]), i+1, chars);
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode ctn = this;
        if(chars.length == 0)
            return false;
        return startsWith_help(ctn,0, chars);
    }

    private boolean startsWith_help(TrieNode ctn, int i, char[] chars) {
        if(i >= chars.length){
            return true;
        }
        if(ctn == null || !ctn.containsKey(chars[i])) {
            return false;
        }
        return startsWith_help(ctn.get(chars[i]), i+1, chars);
    }
    public boolean containsKey(char ch) {
        if(ch -'a' < 0 || ch -'a'>25)
            return false;
        return links[ch - 'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
