package study.streams;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class fork {

    public static void main(String[] args) {

        try {
            testParallel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void testParallel() throws InterruptedException, ExecutionException {
        long firstNum = 1;
        long lastNum = 1_000_000_000;

        List<Long> longList = LongStream.range(firstNum,lastNum).boxed().collect(Collectors.toList());
        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        long sum = forkJoinPool.submit(() -> longList.parallelStream().reduce(0L,Long::sum)).get();

        System.out.println("sum: "+ sum);

    }
}
