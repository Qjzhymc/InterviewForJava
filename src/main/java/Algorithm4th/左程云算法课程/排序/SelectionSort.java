package Algorithm4th.左程云算法课程.排序;

public class SelectionSort {

    /**
     * 1. 选择排序，时间复杂度O(n^2),空间复杂度O(1)
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);//tip1：这一行放在第二个for外面
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {5,7,4,7,3,9};
        int[] res = selectionSort(test);
        for (Integer x: res) {
            System.out.println(x);
        }
    }
}
