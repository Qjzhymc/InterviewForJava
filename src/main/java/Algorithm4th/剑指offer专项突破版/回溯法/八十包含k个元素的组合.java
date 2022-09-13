package Algorithm4th.剑指offer专项突破版.回溯法;


import java.util.LinkedList;
import java.util.List;

public class 八十包含k个元素的组合 {
    List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combine = new LinkedList<>();
        helper(n, k, 1, combine, result);
        return result;
    }
    //i从1到n，表示每个i是不是该选上
    void helper(int n, int k, int i, LinkedList<Integer> combine, List<List<Integer>> result) {
        if (combine.size() == k) {
            result.add(new LinkedList<>(combine));
        } else if (i <= n) {
            helper(n, k, i, combine, result);
            combine.add(i);
            helper(n, k, i+1, combine, result);
            combine.removeLast();
        }
    }
}
