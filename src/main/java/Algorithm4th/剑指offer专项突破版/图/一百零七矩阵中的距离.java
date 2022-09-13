package Algorithm4th.剑指offer专项突破版.图;

import java.util.LinkedList;
import java.util.Queue;

public class 一百零七矩阵中的距离 {
    int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dists = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    dists[i][j] = 0;
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1},{0, 1}};
        while(!queue.isEmpty()) {
            int[] pos = queue.remove();
            int dist = dists[pos[0]][pos[1]];
            for (int[] dir : dirs) {
                int r = pos[0] + dir[0];
                int c = pos[1] + dir[1];
                if (r>=0&&r<rows&&c>=0&&c<cols) {
                    if (dists[r][c] > dist + 1) {
                        dists[r][c] = dist + 1;
                        queue.add(new int[]{r,c});
                    }
                }
            }
        }
        return dists;
    }
}
