package Algorithm4th.左程云算法课程;

import java.util.HashSet;

public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1 ) {
            return 1;
        }
        int i=0;
        int j=1;
        int maxLength = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, j-i+1);
                j++;
            } else {
                while(s.charAt(i) != s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
