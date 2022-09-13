package 线程.JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    //用阻塞队列实现生产者消费者模型
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                //阻塞队列提供了阻塞的take和put方法，如果队列为空，take会阻塞直到队列有元素；如果队列满了，put会阻塞，直到队列有空闲位置。
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("produce..");
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("consume..");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i<2; i++) {
            Producer producer = new Producer();
            producer.start();
        }

        for (int i = 0; i<5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i<3; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }
}
