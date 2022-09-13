package Algorithm4th.左程云算法课程;

/**
 * 将excel列表数字转化为列表名
 */
public class ConvertToTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            int a = (columnNumber - 1) % 26 + 1;
            sb.append((char)('A' + a - 1));
            columnNumber = (columnNumber  - a) / 26;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
//        FXSHRXW
        System.out.println(convertToTitle(2147483647));
    }
}
