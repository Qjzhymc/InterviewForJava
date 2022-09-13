package 线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample {
    public void func1() {
        //1.同步一个代码块，作用于同一个对象，两个线程调用同一个对象才会同步，同一个类的不同对象不会同步，
        synchronized(this) {
            for (int i = 0; i<10; i++) {
                System.out.print(i + ",");
            }
        }
    }

    public void func2() {
        //2.同步一个类，作用了整个类，两个线程调用同一个类的不同对象上的这种同步语句，也会同步
        synchronized(SynchronizedExample.class) {
            for (int i = 0;i < 10; i++) {
                System.out.print(i + ",");
            }
        }
    }

    //3.同步一个静态方法，作用了整个类，两个线程调用同一个类的不同对象上的这种同步语句，也会同步
    public synchronized static void func3() {
        for (int i = 0;i < 10; i++) {
            System.out.print(i + ",");
        }
    }

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //两个线程使用同一个对象的同步代码快，因此会同步
        executorService.execute(()-> e1.func1());
        executorService.execute(()-> e1.func1());


        SynchronizedExample e11 = new SynchronizedExample();
        SynchronizedExample e12 = new SynchronizedExample();
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        //两个线程，各自调用不同对象的同步代码块，因此不同步
        executorService1.execute(()->e11.func3());
        executorService1.execute(()->e12.func3());

    }
}
