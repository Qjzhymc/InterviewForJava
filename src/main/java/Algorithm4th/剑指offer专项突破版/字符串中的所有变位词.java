package Algorithm4th.剑指offer专项突破版;

import java.util.LinkedList;
import java.util.List;

public class 字符串中的所有变位词 {
    /**
     * 找出s1中所有s2的变位词的下标
     * @param s1
     * @param s2
     * @return
     */
    List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> indices = new LinkedList<>();
        if (s1.length() < s2.length()) {
            return indices;
        }
        int[] counts = new int[26];
        int i = 0;
        for (; i<s2.length();i++) {
            counts[s2.charAt(i) - 'a']++;
            counts[s1.charAt(i) - 'a']--;
        }
        if (areAllZero(counts)) {
            indices.add(0);
        }
        for (;i<s1.length();i++) {
            counts[s1.charAt(i) - 'a']--;
            counts[s1.charAt(i-s2.length()) - 'a']++;
            if (areAllZero(counts)) {
                indices.add(i-s2.length() + 1);
            }
        }
        return indices;
    }
    boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
