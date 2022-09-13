package Algorithm4th.剑指offer专项突破版.图;

import java.util.LinkedList;
import java.util.Queue;

public class 一百一十六朋友圈 {
    //方法1：广度优先遍历
    int findCircleNum(int[][] Matrix) {
        int result = 0;
        boolean[] visited = new boolean[Matrix.length];
        for (int i = 0;i<Matrix.length;i++) {
            if (!visited[i]) {
                findCircle(Matrix, visited, i);
                result++;
            }
        }
        return result;
    }
    private void findCircle(int[][] M, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()) {
            int cur = queue.remove();
            for (int friend = 0; friend < M.length; friend++) {
                if (!visited[friend] && M[cur][friend] == 1) {
                    queue.add(friend);
                    visited[friend] = true;
                }
            }
        }
    }
    //方法二：并查集
    int findCircleNum2(int[][] M) {
        int[] fathers = new int[M.length];
        for (int i = 0; i<M.length; i++) {
            fathers[i] = i;
        }
        int count = M.length;
        for (int i = 0; i<M.length; i++) {
            for (int j = i+1; j<M.length; j++) {
                if (M[i][j] == 1 && union(fathers, i, j)) {
                    count--;
                }
            }
        }
        return count;
    }
    private boolean union(int[] fathers, int i, int j) {
        int fatheri = findFather(fathers, i);
        int fatherj = findFather(fathers, j);
        if (fatheri != fatherj) {
            fathers[fatheri] = fatherj;
            return true;
        }
        return false;
    }
    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }
}
