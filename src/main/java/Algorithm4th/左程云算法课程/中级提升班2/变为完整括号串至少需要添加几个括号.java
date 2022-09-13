package Algorithm4th.左程云算法课程.中级提升班2;

public class 变为完整括号串至少需要添加几个括号 {
    /**
     * 判断将一个括号字符串转化为完整括号串至少需要添加多少个括号
     * 用一个count变量辅助
     */
    public int minConv(String str) {
        int count =0;
        int ans = 0;
        for (char ch : str.toCharArray()) {
            if (ch=='(') {
                count++;
            } else {
                if (count == 0) {//当遇到了）括号，且count已经是0了，表示需要补左括号了
                    ans++;
                } else {
                    count--;
                }
            }
        }
        return ans + count;
    }
}
