package Algorithm4th.剑指offer;

public class 替换空格 {
    public static String replaceSpace(String s) {
        int p1 = s.length() - 1;
        StringBuffer sb = new StringBuffer(s);
        for(int i = 0;i<s.length();i++) {
            if (s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }

        for(int p2 = sb.length()-1;p1<=p2&&p1>=0;p1--) {
            if (s.charAt(p1) == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
            } else {
                sb.setCharAt(p2--, s.charAt(p1));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "we are happy";
        String res = replaceSpace(s);
        System.out.println(res);
    }
}
