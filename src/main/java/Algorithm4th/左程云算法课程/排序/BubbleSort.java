package Algorithm4th.左程云算法课程.排序;

public class BubbleSort {

    /**
     * 2.冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = arr.length-1; i>=0;i--){
            for (int j=0;j<i;j++){
                if (arr[j] > arr[j+1]){
                    int temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {5,7,4,7,3,9};
        bubbleSort(test);
        for (Integer x: test) {
            System.out.println(x);
        }
    }
}
