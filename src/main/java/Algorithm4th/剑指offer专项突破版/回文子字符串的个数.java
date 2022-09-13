package Algorithm4th.剑指offer专项突破版;

public class 回文子字符串的个数 {
    /**
     * 判断一个字符串有多少个子字符串是回文
     * @param s
     * @return
     */
    int countSubstrings(String s) {
        if (s==null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0;i<s.length();i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i+1);
        }
        return count;
    }
    int countPalindrome(String s, int i, int j) {
        int count = 0;
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }
}
