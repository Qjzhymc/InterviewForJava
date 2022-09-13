package Algorithm4th.剑指offer专项突破版;

public class 六十五最短的单词编码 {
    int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);

        int[] total = {0};
        dfs(root, 1, total);
        return total[0];
    }
    TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() -1;i>=0;i--) {
                if (node.children[word.charAt(i) - 'a'] == null) {
                    node.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                node = node.children[word.charAt(i) - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    void dfs(TrieNode root, int length, int[] total) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, total);
            }
        }
        if (isLeaf) {
            total[0] += length;
        }
    }

}
