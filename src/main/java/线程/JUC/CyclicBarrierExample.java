package 线程.JUC;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i<10; i++) {
            executorService.execute(() -> {
                System.out.println("before...");
                try {
                    //线程执行await之后计数器会减1，并进行等待，直到计数器为0，所有调用await方法而在等待都线程才会继续执行
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //用于控制多个线程互相等待，只有当多个线程都到达时，这些线程才会继续执行
                System.out.println("after...");
            });
        }
        executorService.shutdown();
    }
}
