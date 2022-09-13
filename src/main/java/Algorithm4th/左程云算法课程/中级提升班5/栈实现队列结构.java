package Algorithm4th.左程云算法课程.中级提升班5;

import java.util.Stack;

public class 栈实现队列结构 {
    /**
     * 如何仅用栈结构实现队列结构
     * 思路：用两个栈，一个push栈，一个pop栈，每次弹出时，先倒出数据倒pop栈中
     */
    class TwoStackQueue{
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;
        TwoStackQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }
        //每次都要dao一遍
        void push(int pushInt) {
            stackPush.push(pushInt);
            dao();
        }
        int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("queue is empty");
            }
            dao();
            return stackPop.pop();
        }
        int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("queue is empty");
            }
            dao();
            return stackPop.peek();
        }
        void dao(){
            if (stackPop.isEmpty()) {
                while(!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }
}
