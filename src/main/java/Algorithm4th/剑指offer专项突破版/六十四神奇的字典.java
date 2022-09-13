package Algorithm4th.剑指offer专项突破版;

public class 六十四神奇的字典 {
    TrieNode root = new TrieNode();
    //构建字典
    void buildDict(String[] dict) {
        for (String word : dict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
    }
    //判断该字符串能够只修改一个字符就匹配上字典里的字符串
    boolean search(String word) {
        return dfs(word, root, 0, 0);
    }
    boolean dfs(String word, TrieNode root, int i, int edit) {
        if (root == null) {
            return false;
        }
        if (root.isWord && i == word.length() && edit == 1) {
            return true;
        }
        if (i<word.length() && edit <= 1) {
            boolean found = false;
            for (int j = 0;j<26 && !found; j++) {
                int next = j== word.charAt(i) - 'a' ? edit : edit + 1;
                found = dfs(word, root.children[j], i+1, next);
            }
            return found;
        }
        return false;
    }


}
