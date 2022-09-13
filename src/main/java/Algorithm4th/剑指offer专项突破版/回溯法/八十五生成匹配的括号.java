package Algorithm4th.剑指offer专项突破版.回溯法;

import java.util.LinkedList;
import java.util.List;

public class 八十五生成匹配的括号 {
    List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        helper(n, n, "", result);
        return result;
    }
    void helper(int left, int right, String parenthesis, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(parenthesis);
        } else {
            if (left > 0) {
                helper(left - 1, right, parenthesis + "(", result);
            }
            if (right > left) {
                helper(left, right - 1, parenthesis + ")", result);
            }
        }
    }
}
