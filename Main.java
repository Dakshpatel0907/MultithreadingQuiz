
import java.util.concurrent.*;

public class Main{

    public static long onethread()
    {
        long sum =0;

        for (long i = 0; i < 1_000_000_000L; i++) {
            sum++;}

        return sum;
    }

    public static long multithread() throws Exception
    {
        ExecutorService executor = Executors.newFixedThreadPool(1000);

        Future<Long>[] futures = new Future[1000];

        for (int t = 0; t < 1000; t++) {

            Callable<Long> task = () -> {
                long sum =0;

                for (long i = 0; i < 1_000_000L; i++) {
                    sum++;}

                return sum;
            };

            futures[t] = executor.submit(task);
        }

        long total =0;

        for (int i = 0; i < 1000; i++) {
            total += futures[i].get();
        }

        executor.shutdown();

        return total;
    }

    public static void main(String[]args) throws Exception {
        long start = System.nanoTime();
        long total = onethread();
        long end = System.nanoTime();

        System.out.println("single threaded sum: " + total);
        System.out.println("time: " + (end-start)/ 1_000_000_000.0 + " seconds");

        long start2 = System.nanoTime();
        long total2 = multithread();
        long end2 = System.nanoTime();

        System.out.println("multi threaded sum: " + total2);
        System.out.println("time: " + (end2-start2)/ 1_000_000_000.0 + " seconds");
    }
}
