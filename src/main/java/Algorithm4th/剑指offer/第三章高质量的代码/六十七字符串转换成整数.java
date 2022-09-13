package Algorithm4th.剑指offer.第三章高质量的代码;

public class 六十七字符串转换成整数 {
    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String newstr = str.trim();
        System.out.println(newstr);
        boolean isNeg = newstr.charAt(0) == '-';

        int res = 0;
        for (int i = 0; i<newstr.length(); i++) {
            char ch = newstr.charAt(i);
            if (i == 0 && (ch == '-' || ch == '+')) {
                break;
            }
            if (ch < '0' || ch > '9') {
                return 0;
            }
            if (!isNeg && res > Integer.MAX_VALUE/10 && ch-'0' > Integer.MAX_VALUE%10) {
                return Integer.MAX_VALUE;
            }
            if (isNeg && res > Integer.MAX_VALUE/10 ) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + (ch - '0');
        }
        return isNeg ? -res : res;
    }

    public static void main(String[] args) {
        int res = strToInt("-91283472332");
        System.out.println(res);
    }
}
