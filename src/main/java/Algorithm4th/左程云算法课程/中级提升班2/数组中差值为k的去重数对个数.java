package Algorithm4th.左程云算法课程.中级提升班2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 数组中差值为k的去重数对个数 {
    /**
     * 给定一个数组arr，返回差值为k的去重数对个数
     * 思路：将所有数字加入hashset中，再一个个遍历看arr[i]+k的值在不在hashset中，在就加入结果集中
     */
    public List<List<Integer>> findPair(int[] arr, int k) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int a:arr) {
            set.add(a);
        }
        for (int a:arr) {
            if (set.contains(a+k)) {
                res.add(Arrays.asList(a, a+k));
            }
        }
        return res;
    }
}
