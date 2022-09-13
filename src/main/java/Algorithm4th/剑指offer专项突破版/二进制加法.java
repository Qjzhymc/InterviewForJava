package Algorithm4th.剑指offer专项突破版;


public class 二进制加法 {
    /**
     * 方法1：字符串类型的加法
     * 从右往左一步步加过去，更符合直观理解
     * @param a
     * @param b
     * @return
     */
    static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() -1;
        int j = b.length() -1;
        int carry = 0;
        while(i>=0 || j>= 0) {
            int digitA = i>= 0 ? a.charAt(i) - '0' : 0;
            int digitB = j>= 0 ? b.charAt(j) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum>=2 ? sum - 2 : sum;
            result.append(sum);
            i--;
            j--;
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    /**
     * 方法2：这种是整数类型的加法
     * @param a
     * @param b
     * @return
     */
    int Add(int a, int b) {
        return b==0 ? a: Add(a^b, (a & b) << 1);
    }

    public static void main(String[] args) {
        String res = addBinary("001", "110");
        System.out.println(res);
    }
}
