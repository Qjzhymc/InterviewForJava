package Algorithm4th.左程云算法课程.中级提升班1;

public class 矩阵中边框全是1的最大正方形的边长长度 {

    /**
     * 给定一个N*N的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的边长长度
     * tips1：一个边长为n的正方形，有n^4个子矩阵
     * tips2: 一个边长为n的正方形，有n^3个子正方形
     * 1.使用两个辅助矩阵，一个right矩阵中每个元素表示包括自己在内，右边有多少个连续的1；
     *   一个down矩阵中每个元素表示包括自己在内，下方有多少个连续的1；
     * 2.然后在点(row,col)位置上判断右下方有没有边长为border的正方形时，只需判断是不是right[row][col]>=border,down[row][col]>=border
     */
    public int largest1BorderedSquare(int[][] matrix) {
        return 0;
    }

}
