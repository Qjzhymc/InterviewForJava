import java.util.concurrent.CountDownLatch;

public class test3 {
    public static void main(String[] args) {
        final Object lock = new Object();
        CountDownLatch count = new CountDownLatch(50);
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i<100; i+=2) {
                synchronized (lock) {
                    System.out.println("thread1 " + i);
//                    count.countDown();
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 2; i<100; i+=2) {
                synchronized (lock) {
                    System.out.println("thread2: " + i);
//                    count.countDown();
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
//        thread1.interrupt();
//        thread2.interrupt();
    }
}
