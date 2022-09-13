import Algorithm4th.String;
import com.google.gson.Gson;

public class HelloWorld {

    public static void main(String[] args) {
            final Object lock = new Object();
            Thread thread1 = new Thread(() -> {
                for (int i = 1; i<100; i+=2) {
                    synchronized (lock) {
                        System.out.println("thread1" + i);
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
                        System.out.println("thread2" + i);
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
    }
}
