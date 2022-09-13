package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 十二矩阵中的路径 {
    /**
     * 路径搜索
     */
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (helper(i, j, board, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(int r, int c, char[][] board, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c] == word.charAt(index) && !visited[r][c]) {
            visited[r][c] = true;
            for (int[] dir : dirs) {
                int newR = r+dir[0];
                int newC = c+dir[1];
                //这里一定要记得return
                if(helper(newR, newC, board, word, index+1, visited)) {
                    return true;
                }
            }
        } else {
            return false;
        }
        visited[r][c] = false;
        return false;
    }
}
