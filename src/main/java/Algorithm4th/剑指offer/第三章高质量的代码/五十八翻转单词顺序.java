package Algorithm4th.剑指offer.第三章高质量的代码;

public class 五十八翻转单词顺序 {
    public static String reverseWords(String s) {
        String rev = reverse(s);
        System.out.println(rev);
        String[] arr = rev.split("\\s+");
        StringBuilder sb= new StringBuilder();
        for(String str : arr) {
            sb.append(reverse(str));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = reverseWords("the sky is blue");
        System.out.println(s);
    }
}
