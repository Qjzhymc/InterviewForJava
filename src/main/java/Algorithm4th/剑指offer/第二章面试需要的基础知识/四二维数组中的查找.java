package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 四二维数组中的查找 {
    /**
     * 二维数组中每一行从左到右升序，每一列从上到下升序，查找target是否在矩阵中
     * @param matrix
     * @param target
     * @return
     */
    boolean findInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;
        while (r<rows && c>=0) {
            int num = matrix[r][c];
            if (num == target) {
                return true;
            }
            if (num < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}
