package 线程.线程之间的协作;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSingalExample {
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void after() {
        lock.lock();
        try {
            //await与wait相比，await可以指定等待的条件，一般和Condition类一起使用，condition对象调用await使线程等待，其他线程
            //调用signal 或 signalAll 唤醒等待的线程。
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSingalExample awaitSingalExample = new AwaitSingalExample();
        executorService.execute(() -> awaitSingalExample.after());
        executorService.execute(() -> awaitSingalExample.before());
    }
}
