package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 五替换空格 {
    /**
     * 将str中每个空格用%20替换
     * 时间复杂度是O(n)
     * @param str
     * @return
     */
    static String replace(String str) {
        //处理特殊输入
        if (str == null || str.length() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i<str.length(); i++) {
            if (str.charAt(i) == ' ') {
                builder.append("  ");
            }
        }
        int i = str.length() - 1;
        int j = builder.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == ' ') {
                builder.setCharAt(j--, '0');
                builder.setCharAt(j--, '2');
                builder.setCharAt(j, '%');
            } else {
                builder.setCharAt(j, str.charAt(i));
            }
            i--;
            j--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String str = "we are happy";
        System.out.println(replace(str));
    }
}
