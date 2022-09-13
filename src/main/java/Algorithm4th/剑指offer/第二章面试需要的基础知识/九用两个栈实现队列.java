package Algorithm4th.剑指offer.第二章面试需要的基础知识;

import java.util.Stack;

public class 九用两个栈实现队列 {
    class CQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                //异常处理，如果本来就都没有值，会返回-1
                if (stack2.isEmpty()) {
                    return -1;
                }
                return stack2.pop();
            }
        }
    }
}
