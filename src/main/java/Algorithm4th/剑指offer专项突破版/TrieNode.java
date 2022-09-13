package Algorithm4th.剑指offer专项突破版;

public class TrieNode {
    TrieNode[] children;
    boolean isWord;
    TrieNode(){
        children = new TrieNode[26];
    }
}
