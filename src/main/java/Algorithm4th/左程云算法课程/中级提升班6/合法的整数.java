package Algorithm4th.左程云算法课程.中级提升班6;

public class 合法的整数 {
    /**
     * 给定一个字符串，返回是不是正常的整数
     */
    public boolean isValid(char[] str) {
        //情况1：第一个字符是'-'之外的其他字符，无效
        if (str[0] != '-' && (str[0] < '0' || str[0] >'9')) {
            return false;
        }
        //情况2：开头是'-'，但只有一个'-'，或'-'后面是0
        if (str[0] == '-' && (str.length == 1 || str[1] == '0')) {
            return false;
        }
        //情况3：只有一个'0'
        if (str[0] == '0' && str.length == 1) {
            return false;
        }
        for (int i = 1;i<str.length;i++) {
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }
    /**
     * 给定一个字符串，转化为整数
     */
    int convert(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        if (!isValid(str)) {
            throw new RuntimeException("can not convert");
        }
        boolean neg = str[0] == '-'? true :false;
        int minq = Integer.MIN_VALUE/10;
        int minr = Integer.MIN_VALUE %10;
        int res = 0;
        int cur = 0;
        for (int i = neg?1:0;i<str.length;i++) {
            cur = '0' -str[i];
            if ((res<minq) || (res == minq && cur < minr)) {
                throw new RuntimeException("can not convert");
            }
            res = res * 10 + cur;
        }
        if (!neg && res == Integer.MIN_VALUE) {
            throw new RuntimeException("can not convert");
        }
        return neg ? res: -res;
    }
}
