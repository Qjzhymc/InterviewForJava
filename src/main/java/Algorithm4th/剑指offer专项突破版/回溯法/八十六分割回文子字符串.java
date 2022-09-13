package Algorithm4th.剑指offer专项突破版.回溯法;

import java.util.LinkedList;
import java.util.List;

public class 八十六分割回文子字符串 {
    List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        helper(s, 0, new LinkedList<String>(), result);
        return result;
    }
    void helper(String s, int index, LinkedList<String> substrings, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new LinkedList<>(substrings));
        } else {
            for (int i = index; i<s.length();i++) {
                if (isPalindrome(s, index, i)) {
                    substrings.add(s.substring(index, i+1));
                    helper(s, i+1, substrings, result);
                    substrings.removeLast();
                }
            }
        }
    }
    boolean isPalindrome(String s, int start, int end) {
        while(start<end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
