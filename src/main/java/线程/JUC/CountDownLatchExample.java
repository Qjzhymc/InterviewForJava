package 线程.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException{
        final int totalThread = 10;
        //countDownLatch用于控制一个或多个线程等待多个线程
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i<10; i++) {
            executorService.execute(() -> {
                System.out.println("run...");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end...");
        executorService.shutdown();
    }
}
