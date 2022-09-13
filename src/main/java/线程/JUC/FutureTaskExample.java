package 线程.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i<100; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });
        //FutureTask用于异步获取执行结果或取消执行任务的场景，当一个任务执行需要很长时间，
        // 那么可以用futureTask封装这个任务，主线程在完成自己的任务之后再去获取结果
        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());

    }
}
