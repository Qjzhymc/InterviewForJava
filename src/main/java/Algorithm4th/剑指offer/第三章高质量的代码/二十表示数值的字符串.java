package Algorithm4th.剑指offer.第三章高质量的代码;

public class 二十表示数值的字符串 {
    public static boolean isNumber(String s) {
        // if (s==null || s.length() == 0) {
        //     return false;
        // }
        // return s.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");

        if (s == null || s.length() == 0)
            return false;
        return new String(s).matches("[+-]?\\d+(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        String s = ".1";
        System.out.println(isNumber(s));
    }
}
