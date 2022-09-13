package Algorithm4th.左程云算法课程.leetcode竞赛;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 查找和替换模式 {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word: words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }
    public static boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reMap= new HashMap<>();
        for(int i = 0;i<pattern.length();i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (map.containsKey(p)) {
                System.out.println("map.get("+p+")=" + map.get(p) + ",w=" +w);
                if (map.get(p) != w) {
                    return false;
                }
            } else {
                if (reMap.containsKey(w)) {
                    return false;
                } else {
                    map.put(p, w);
                    reMap.put(w, p);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words={"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words, pattern));
    }
}
