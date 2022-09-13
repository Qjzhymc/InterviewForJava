package Algorithm4th.左程云算法课程.排序;

public class SmallSum {
    /**
     * 小和问题：求一个数组的小和，等价于一个数右边右多少个数比他大
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int l, int r){
        if (l == r){
            return  0;
        }

        int mid = l + ((r-l)>>1);
        return process(arr, l, mid)
                + process(arr, mid+1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r){
        int[] helper = new int[r - l +1];
        int i = 0;
        int p1 = l;
        int p2 = m +1;
        int res =0;
        while(p1<=m && p2<=r){
            res += arr[p1] < arr[p2] ? (r-p2+1) * arr[p1] : 0;
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            helper[i++] = arr[p1++];
        }
        while(p2<=r){
            helper[i++] = arr[p2++];
        }
        for (int j = 0;j<helper.length;j++){
            arr[l + j] = helper[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {5,7,4,7,3,9};
        int res = smallSum(test);
        System.out.println(res);
    }
}
