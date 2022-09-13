package Algorithm4th.左程云算法课程.排序;

public class HeapSearch {


    /**
     * 6.堆排
     * @param arr
     */
    public static void heapSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        //第一步，先将整个数组构成一个大根堆
        for (int i=0;i<arr.length;i++){
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while(heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr, index, (index-1)/2);
            index = (index -1) /2;
        }
    }

    /*
    * 某个数在index位置，能否往下移动
    * */
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 +1;//左孩子的下标
        while(left < heapSize){
            int largest = left + 1 < heapSize && arr[left +1] > arr[left] ? left +1 : left; //把左右孩子较大的下标返回给largest
            largest = arr[largest] > arr[index] ? largest: index;
            if (largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;

        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] test = {5,7,4,7,3,9};
        heapSort(test);
        for (Integer x: test) {
            System.out.println(x);
        }
    }
}
