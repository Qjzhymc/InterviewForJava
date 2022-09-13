package Algorithm4th.左程云算法课程.递归;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        process(nums, list);
        return res;
    }

    public static void process(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list)); //大坑！！！一定要复制一份新建对象。java中对象参数是引用传递，会改变原来的值，所以需要复制一份新建对象。
        } else {
            for (Integer num: nums) {
                if (!list.contains(num)) {
                    list.add(num);
                    process(nums, list);
                    list.remove(num);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);

    }
}
