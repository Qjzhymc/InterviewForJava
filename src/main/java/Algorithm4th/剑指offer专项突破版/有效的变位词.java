package Algorithm4th.剑指offer专项突破版;

import java.util.HashMap;
import java.util.Map;

public class 有效的变位词 {
    //只考虑英文小写字符，用一个数组表示哈希表
    boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char ch : str1.toCharArray()) {
            counts[ch-'a']++;
        }
        for (char ch : str2.toCharArray()) {
            if (counts[ch-'a'] == 0) {
                return false;
            }
            counts[ch-'a']--;
        }
        return true;
    }
    //如果不只是小写英文字符，需要考虑其他字符，则用真正的哈希表
    boolean isAnagram2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            if (!counts.containsKey(ch) || counts.get(ch) == 0) {
                return false;
            }
            counts.put(ch, counts.get(ch) - 1);
        }
        return true;
    }
}
