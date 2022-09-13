package Algorithm4th.剑指offer专项突破版.排序;

public class 七十五数组相对排序 {
    int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            while(counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }

        for (int num = 0;num<counts.length;num++) {
            while(counts[num] > 0) {
                arr1[i++] = num;
                counts[num]--;
            }
        }
        return arr1;
    }
}
