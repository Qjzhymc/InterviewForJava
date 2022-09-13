package Algorithm4th.左程云算法课程.二叉树;

public class PrintAllFolds {
    /**
     * 给定一个n值，求一个纸条折n次后，折痕的方向序列
     */
    public static void printAllFolds(int N){
        printProcess(1, N, true);
    }

    public static void printProcess(int i, int N, boolean down){
        if (i>N){
            return;
        }
        printProcess(i+1, N,true);
        System.out.println(down? "凹":"凸");
        printProcess(i+1,N,false);
    }

    public static void main(String[] args) {
        printAllFolds(3);
    }
}
