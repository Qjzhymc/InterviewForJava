package Algorithm4th.剑指offer.第二章面试需要的基础知识;

public class 十三机器人的运动范围 {
    /**
     * 路径搜索
     */
    int count = 0;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        helper(0, 0, m, n, k, visited);
        return count;
    }
    void helper(int r, int c, int m, int n, int k, boolean[][] visited) {
        if (r>=0 && c>=0 && r<m && c<n && !visited[r][c] && canReach(r, c) <= k) {
            count++;
            visited[r][c] = true;
            for (int[] dir : dirs) {
                int newR = r+dir[0];
                int newC = c+dir[1];
                helper(newR, newC, m, n, k, visited);
            }
        }
    }
    private int canReach(int r, int c) {
        int res = 0;
        while(r!=0) {
            res = res + r%10;
            r = r/10;
        }
        while(c!=0) {
            res = res + c%10;
            c = c/10;
        }
        return res;
    }
}
