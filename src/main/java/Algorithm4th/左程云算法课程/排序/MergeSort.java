package Algorithm4th.左程云算法课程.排序;

public class MergeSort {

    /**
     * 4.归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        process(arr, 0, arr.length-1);
    }

    public static void process(int[] arr, int L, int R){
        if (L == R){
            return;
        }
        int mid = L + ((R -L) >> 1);  //右移操作一定要用括号括起来
        process(arr, L, mid);
        process(arr, mid+1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R -L +1];
        int i =0;
        int p1 = L;
        int p2 = mid+1;
        while(p1<=mid && p2<=R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=R){
            help[i++] = arr[p2++];
        }

        for (int j =0;j<help.length;j++){
            arr[L+j] = help[j];
        }

    }

    public static void main(String[] args) {
        int[] test = {5,7,4,7,3,9};
        mergeSort(test);
        for (Integer x: test) {
            System.out.println(x);
        }
    }

}
