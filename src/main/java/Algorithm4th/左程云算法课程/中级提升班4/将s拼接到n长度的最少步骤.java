package Algorithm4th.左程云算法课程.中级提升班4;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLMessage;

public class 将s拼接到n长度的最少步骤 {
    /**
     * 假设s和m初始化，s = "a";m = s;
     * 再定义两种操作，第一种操作：
     * m=s;
     * s=s+s;
     * 第二种操作：
     * s=s+m;
     * 求最少的操作步骤数，可以将s拼接到长度等于n
     *
     * 思路：结论1：当n是质数时，只用第二种操作是最少的步骤数
     * 结论2：当n不是质数时，当n=a*b*c*d (其中a,b,c,d都是质数)
     *
     */
    public int minOps(int n) {
        if (n<2) {
            return 0;
        }
        //当n是质数时，
        if (isPrim(n)) {
            return n-1;
        }
        //当n不是质数时，求(能分解的所有质数的和)和(质数个数)
        int[] divSumAndCount = divsSumAndCount(n);
        return divSumAndCount[0] - divSumAndCount[1];
    }

    public int[] divsSumAndCount(int n) {
        int sum = 0;
        int count = 0;
        for (int i=2;i<=n;i++) {
            while (n%i == 0){
                sum += i;
                count++;
                n /= i;
            }
        }
        return new int[] {sum, count};
    }
    //判断n是否是质数
    boolean isPrim(int n) {
        for (int i = 2;i<n;i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
