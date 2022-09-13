package Algorithm4th.剑指offer专项突破版;

import java.util.List;

public class 六十三替换单词 {
    //构建词根前缀树
    TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
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
        return root;
    }
    //找到单词word对应的词根，找不到用空代替
    String findPrefix(TrieNode root, String word) {
        TrieNode node = root;
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (node.isWord || node.children[ch - 'a'] == null) {
                break;
            }
            builder.append(ch);
            node = node.children[ch - 'a'];
        }
        if (node.isWord) {
            return builder.toString();
        } else {
            return "";
        }
    }
    //替换句子中的所有单词，换成词根
    String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        StringBuilder builder = new StringBuilder();

        String[] words = sentence.split(" ");
        for (int i = 0;i<words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!prefix.isEmpty()) {
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }
}
