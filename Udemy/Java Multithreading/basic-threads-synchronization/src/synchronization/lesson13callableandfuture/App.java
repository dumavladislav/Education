package synchronization.lesson13callableandfuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        /*
        Future & Callable are the way to get return value from the threads
         */

        Future<Integer> future = executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {

                int duration = new Random().nextInt(4000);

                // just to simulate the exception
                if(duration > 2000) {
                    throw new IOException("Waiting for too long");
                }

                System.out.println("Starting ...");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished.");

                return duration;
            }
        });

        executor.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            // execution exception handling
            System.out.println(e);;
        }
    }

}
