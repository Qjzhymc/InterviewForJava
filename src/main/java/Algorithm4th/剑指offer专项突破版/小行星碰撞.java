package Algorithm4th.剑指offer专项突破版;

import java.util.Stack;

public class 小行星碰撞 {
    int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids) {
            while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -as) {
                stack.pop();
            }
            if (!stack.isEmpty() && as < 0 && stack.peek() == -as) {
                stack.pop();
            } else if (as > 0 || stack.empty() || stack.peek() < 0) {
                stack.push(as);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
