package Algorithm4th.剑指offer专项突破版;

public class 六十六单词之和 {

    class TrieNode{
        TrieNode[] children;
        int value;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    //
    void insert(String key, int val) {
        TrieNode node = root;
        for (int i = 0;i<key.length();i++) {
            char ch = key.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.value = val;
    }
    //
    int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0;i<prefix.length();i++) {
            char ch = prefix.charAt(i);
            if (node.children[ch - 'a'] ==null){
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return getSum(node);
    }

    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int result = node.value;
        for (TrieNode child : node.children) {
            result += getSum(child);
        }
        return result;
    }


}
