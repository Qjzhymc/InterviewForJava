package Algorithm4th.剑指offer第二版2023;

public class IntDivision {
    public static int divide(int a, int b) {
        int negative = 2;
        if (a > 0) {
            a = -a;
            negative--;
        }
        if (b > 0) {
            b = -b;
            negative--;
        }
        int result = divideForPositive(a, b);
        return negative == 1 ? -result : result;
    }

    //两个正整数相除
    public static int divideForPositive(int a, int b) {
        int result = 0;
        while(a <= b) {
            int value = b;
            int quotient = 1;
            while(value >= 0xc0000000 && value + value >= a) {
                quotient += quotient;
                value += value;
            }
            result += quotient;
            a = a - value;
        }
        return result;
    }

    public static void main(String[] args) {
//        int result = divide(-2147483648, 1);
        int result = 1073741824;
        System.out.println(result+result-1);
    }
}
