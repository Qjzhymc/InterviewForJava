package Algorithm4th.剑指offer专项突破版;

public class 字符串中的变位词 {
    /**
     * 判断s2字符串的所有子串中是否有s1变位词
     * @param s1
     * @param s2
     * @return
     */
    boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()){
            return false;
        }
        int[] counts = new int[26];
        //初始化的时候同时初始化s1，和s2
        for (int i =0;i<s1.length();i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        if (areAllZero(counts)) {
            return true;
        }
        for (int i = s1.length();i<s2.length();i++) {
            counts[s2.charAt(i) - 'a']--; //新进来的--
            counts[s2.charAt(i-s1.length()) - 'a']++;// 退出的++
            if (areAllZero(counts)) {
                return true;
            }
        }
        return false;
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
