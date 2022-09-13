package Algorithm4th.剑指offer专项突破版;

public class 最多删除一个字符得到回文 {
    boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (; start<s.length()/2;start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }
        return start == s.length() / 2 || isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
    }
    boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start++;
            end--;
        }
        return start >= end;
    }
}
