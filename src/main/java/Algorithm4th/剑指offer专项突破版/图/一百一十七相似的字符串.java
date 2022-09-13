package Algorithm4th.剑指offer专项突破版.图;

public class 一百一十七相似的字符串 {
    int numSimilarGroups(String[] A) {
        int[] fathers = new int[A.length];
        for (int i = 0;i<A.length;i++) {
            fathers[i] = i;
        }
        int groups = A.length;
        for (int i = 0; i<A.length; i++) {
            for (int j = i+1; j<A.length;j++) {
                if (similar(A[i], A[j]) && union(fathers, i, j)) {
                    groups--;
                }
            }
        }
        return groups;
    }
    private boolean similar(String str1, String str2) {
        int diffCount = 0;
        for (int i = 0; i<str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount <= 2;
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
