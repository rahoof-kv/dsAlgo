package study.thread;

import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceTest {

    public static void main(String[] args) {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        Future<Integer> future = executorService.submit(new CpuIntensiveTask());

        Integer val = null;
        try {
            val = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("val:" + val);
    }

    static class CpuIntensiveTask implements Callable<Integer> {

        @Override
        public Integer call() {

            System.out.println(Thread.currentThread());

            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return new Random().nextInt();
        }
    }
}
