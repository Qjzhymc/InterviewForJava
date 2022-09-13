package Algorithm4th.剑指offer专项突破版.图;

import java.util.LinkedList;
import java.util.Queue;

public class 一百零五最大的岛屿 {
    int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        int maxArea = 0;
        for (int i = 0;i<rows;i++) {
            for (int j = 0;j<cols; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    int area = getArea(grid, isVisited, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        queue.add(new int[]{i, j});
        int area = 0;
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] pos = queue.remove();
            area++;
            for (int[] dir : dirs) {
                int row = pos[0] + dir[0];
                int col = pos[1] + dir[1];
                if (row>=0 && row<grid.length && col >=0 && col <grid[0].length && !visited[row][col] && grid[row][col] == 1) {
                    visited[row][col] = true;
                    queue.add(new int[]{row, col});
                }
            }
        }
        return area;
    }
}
