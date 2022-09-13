package Algorithm4th.剑指offer专项突破版;

public class 六十七最大的异或 {
    class TrieNode{
        TrieNode[] children;
        TrieNode() {
            children = new TrieNode[2]; //只用两个分支，分别表示0和1
        }
    }

    TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31;i>=0;i--) {
                int bit = num >> i & 1;//判断这个位是0还是1
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        return root;
    }

    //找异或最大值
    int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31;i>=0;i--) {
                int bit = num>>i & 1;
                if (node.children[1-bit] != null) {
                    xor = (xor << 1)+1;
                    node = node.children[1-bit];
                } else {
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }



}
