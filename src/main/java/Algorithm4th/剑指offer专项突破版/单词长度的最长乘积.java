package Algorithm4th.剑指offer专项突破版;

public class 单词长度的最长乘积 {
    int maxProduct(String[] words) {
        //首先用一个数组表示每个字符串的字符分布，用int整数的位分布反应26个字符的分布，字符存在，位为1，字符不存在，位为0
        int[] flags = new int[words.length];
        for (int i = 0;i<words.length;i++) {
            String word = words[i];
            for (char ch : word.toCharArray()) {
                flags[i] |= 1 << (ch - 'a');
            }
        }
        int result = 0;
        for (int i =0;i<words.length;i++) {
            for (int j =i+1;j<words.length;j++) {
                //表示第i个字符串与第j个字符串每个位都不一样，表示没有相同的字符
                if ((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}
