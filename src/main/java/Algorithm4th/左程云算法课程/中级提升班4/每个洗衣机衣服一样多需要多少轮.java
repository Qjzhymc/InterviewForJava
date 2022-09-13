package Algorithm4th.左程云算法课程.中级提升班4;

public class 每个洗衣机衣服一样多需要多少轮 {
    /**
     * 给定一个数组表示每个洗衣机里的衣服数量，每一轮每个洗衣机都可以把自己洗衣机里的一件衣服放到左边或右边，
     * 求要让每一个洗衣机的衣服一样多，需要多少轮？
     * 思路：算出每个洗衣机最少需要多少轮保证左右平衡，然后选出全部最多的轮作为结果
     */
    public static int MinOps(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        int sum = 0;
        for (int i = 0;i<size;i++) {
            sum += arr[i];
        }
        if (sum % size != 0) {
            return -1;
        }

        int avg = sum/size;
        int leftSum = 0;
        int ans = 0;
        for (int i =0;i<size;i++) {
            int leftRes = leftSum - avg*i;
            int rightRes = (sum-leftSum-arr[i]) - avg*(size-i-1);
            if (leftRes<0 && rightRes<0) {
                ans = Math.max(ans, Math.abs(leftRes) + Math.abs(rightRes));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRes), Math.abs(rightRes)));
            }
            leftSum += arr[i];
        }
        return ans;
    }

}
