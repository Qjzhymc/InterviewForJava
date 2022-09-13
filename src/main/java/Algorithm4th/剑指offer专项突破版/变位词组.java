package Algorithm4th.剑指offer专项突破版;

import java.util.*;

public class 变位词组 {
    List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            groups.putIfAbsent(sorted, new LinkedList<>());
            groups.get(sorted).add(str);
        }
        return new LinkedList<>(groups.values());
    }
}
