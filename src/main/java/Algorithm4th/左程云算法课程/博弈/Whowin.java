package Algorithm4th.左程云算法课程.博弈;

public class Whowin {
    /**
     * 给定bolls个求，bolls为奇数， 甲先选球，乙后选球，每次可以选1，2，3个球，返回最后谁拥有的球数是偶数个。
     * @param bolls
     * @return
     */
    static String whowin(int bolls) {
        return process(0, bolls, 0, 0);
    }

    static String process(int turn, int rest, int jia, int yi){
        if (rest == 0){
            return jia % 2 ==0 ? "甲" : "乙";
        }
        //甲来选
        if (turn == 0) {
            for (int pick = 1; pick <= Math.min(3, rest); pick++){
                String res = process(1, rest - pick, jia + pick, yi);
                if (res == "甲") {
                    return "甲";
                }
            }
            return "乙";
        } else { //乙来选
            for (int pick = 1; pick <= Math.min(3, rest); pick++){
                String res = process(0, rest - pick, jia, yi+ pick);
                if (res == "乙") {
                    return "乙";
                }
            }
            return "甲";
        }
    }

    public static void main(String[] args) {
        for (int i = 1;i<100;i += 2){
            System.out.println("球为"+i+"个时，"+whowin(i)+"赢");
        }
    }

}
