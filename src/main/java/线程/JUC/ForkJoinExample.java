package 线程.JUC;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample extends RecursiveTask<Integer> {

    private final int threshold = 5;
    private int first;
    private int last;

    public ForkJoinExample(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if ((last-first) < threshold) {
            for (int i = first; i<=last; i++) {
                result += i;
            }
        } else {
            int middle = first + (last - first)/2;
            ForkJoinExample leftTask = new ForkJoinExample(first, middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle, last);
            leftTask.fork(); //forkJoin用于将大的计算任务拆分成小的计算任务并行计算
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinExample forkJoinExample = new ForkJoinExample(1, 10000);
        //forkJoinPool是一个特殊的线程池，
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //forkJoin使用工作窃取算法提高cpu的利用率， 每个线程都维护一个双端队列，用来存储需要执行的任务，
        // 允许空闲的线程从其他线程的双端队列中窃取一个任务来执行，窃取的任务必须是最晚的任务，避免发生竞争。
        Future result = forkJoinPool.submit(forkJoinExample);
        System.out.println(result.get());
    }
}
