package Algorithm4th.剑指offer专项突破版.图;

public class 一百一十二最长递增路径 {
    int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        //保存每个点出发点最长递增路径的长度
        int[][] lengths = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for (int i = 0;i<matrix.length; i++) {
            for (int j =0; j<matrix[0].length; j++) {
                int length = dfs(matrix, lengths, i, j);
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
    private int dfs(int[][] matrix, int[][] lengths, int i, int j) {
        if (lengths[i][j] > 0) {
            return lengths[i][j];
        }

        int length = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r>=0 && c>=0 && r<matrix.length && j<matrix[0].length && matrix[i][j] < matrix[r][c]) {
                int path = dfs(matrix, lengths, r, c);
                length = Math.max(path + 1, length);
            }
        }
        lengths[i][j] = length;
        return length;
    }
}
