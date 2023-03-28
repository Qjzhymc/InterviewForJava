package Algorithm4th.剑指offer第二版2023;

public class 单词长度的最大乘积 {
    public static int maxProduct(String[] words) {
        boolean[][] flags = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                flags[i][ch-'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                for (int k = 0; k < 26; k++) {
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                    if (k == 25) {
                        int prod = words[i].length() * words[j].length();
                        result = Math.max(result, prod);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "foo", "bar", "fxyz", "abcdef"};
        int result = maxProduct(words);
        System.out.println(result);
    }
}
