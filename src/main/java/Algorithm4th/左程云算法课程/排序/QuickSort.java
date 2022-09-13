package Algorithm4th.左程云算法课程.排序;

public class QuickSort {

    /**
     * 5. 快速排序，3.0
     * @param arr
     */
    public static void sort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int L, int R){
        if (L < R){
            swap(arr, L + (int)(Math.random() * (R-L+1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R){
        int less = L-1; //小于区域右边界
        int more = R;  //大于区域左边界
        while(L < more){
            if (arr[L] < arr[R]){
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less++, more};
    }

    public static void main(String[] args) {
        int[] test = {5,7,4,7,3,9};
        sort(test);
        for (Integer x: test) {
            System.out.println(x);
        }
    }



    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
