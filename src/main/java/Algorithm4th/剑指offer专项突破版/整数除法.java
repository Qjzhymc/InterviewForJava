package Algorithm4th.剑指offer专项突破版;

public class 整数除法 {
    /**
     * 不能使用*,/,%,当发生溢出时，返回最大的整数值
     * @param dividend  被除数
     * @param divisor 除数
     * @return
     */
    static int divide(int dividend, int divisor) {
        //当(-2^31)/(-1)时，等于2^31，会溢出
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //将被除数和除数都以负数都形式去运行
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }
    static int divideCore(int dividend, int divisor) {
        int result = 0;
        //由于被除数和除数都是负数，注意这里都符号都意义都反过来
        while(dividend<=divisor) {
            int value = divisor; // value = divisor * 2^k
            int quotient = 1;//quotient = k
            //找到quotient，使得dividend>divisor*2^k,但dividend<divisor*2^k*2
            while (value >= 0xc0000000 && dividend <= value + value) {
                value += value;
                quotient += quotient;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(15, 7));
    }
}
