package Algorithm4th.剑指offer专项突破版.图;

public class 一百一十八多余的边 {
    int[] findRedundantConnection(int[][] edges) {
        int maxVertex = 0;
        for (int[] edge : edges) {
            maxVertex = Math.max(maxVertex, edge[0]);
            maxVertex = Math.max(maxVertex, edge[1]);
        }
        int[] fathers = new int[maxVertex+1];
        for (int[] edge : edges) {
            if (!union(fathers, edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[2];
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
