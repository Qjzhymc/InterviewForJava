package 线程;

import java.util.concurrent.*;

public class ExecutorsExample {

    static class MyCallable implements Callable {
        @Override
        public Integer call() throws Exception {
            System.out.println("实现Callable创建线程，使用FutureTask封装");
            return 23;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(myCallable);

        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> {
//            try{
//                Thread.sleep(2000);
//                System.out.println("Thread run");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        //shutdownNow会立即停止线程池所有任务的调度
//        executorService.shutdownNow();
//        System.out.println("Main run");
//
//        Future<?> future = executorService.submit(()->{
//
//        });
//        future.cancel(true);


    }
}
