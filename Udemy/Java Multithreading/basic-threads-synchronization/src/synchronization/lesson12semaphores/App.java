package synchronization.lesson12semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws InterruptedException {
        /****************** Initial Tests

        Semaphore sem = new Semaphore(1); // Initial amount of permits

        // increment the amount of permits
        sem.release();

        // decrement the amount of permits. If no permits are available, acquire will wait for someone to release one
        sem.acquire();

        System.out.println("Available permits: " + sem.availablePermits());*/



        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0; i<200; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

    }

}
