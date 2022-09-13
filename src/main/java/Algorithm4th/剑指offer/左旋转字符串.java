package Algorithm4th.剑指offer;

public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        String res = s + s;
        return res.substring(n, n+s.length());
    }
}
