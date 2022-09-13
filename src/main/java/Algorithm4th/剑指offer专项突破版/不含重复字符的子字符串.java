package Algorithm4th.剑指offer专项突破版;

public class 不含重复字符的子字符串 {
    int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] counts = new int[256];
        int j=-1;
        int longest = 1;
        for (int i = 0;i<s.length();i++) {
            counts[s.charAt(i)]++;
            //左边的j一直右移，直到counts里没有重复的字符
            while(hasGreaterThan1(counts)) {
                ++j;
                counts[s.charAt(j)]--;
            }
            longest = Math.max(longest, i -j);
        }
        return longest;
    }
    boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
