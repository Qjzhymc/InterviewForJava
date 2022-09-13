package Algorithm4th.左程云算法课程;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class 包含min函数的栈 {
        Stack<Integer> stack;
        Queue<Integer> queue;

        /** initialize your data structure here. */
        public 包含min函数的栈() {
            stack = new Stack<>();
            queue = new PriorityQueue<>();
        }

        public void push(int x) {
            this.stack.push(x);
            queue.add(x);
        }

        public void pop() {
            int x = this.stack.pop();
            queue.remove(x);
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return queue.peek();
        }

    public static void main(String[] args) {
//            ["MinStack","push","push","push","top","pop","min","pop","min","pop","push","top","min","push","top","min","pop","min"]
//[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        包含min函数的栈 s = new 包含min函数的栈();
        s.push(2147483646);
        s.push(2147483646);
        s.push(2147483647);
        System.out.println(s.top());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        s.push(2147483647);
        System.out.println(s.top());
        System.out.println(s.min());
        s.push(-2147483648);
        System.out.println(s.top());
        System.out.println(s.min());//
        s.pop();
        System.out.println(s.min());

    }
}
