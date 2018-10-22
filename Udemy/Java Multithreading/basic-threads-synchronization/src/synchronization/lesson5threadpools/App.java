package synchronization.lesson5threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed: " + id);
    }
}

public class App {

    public static void main(String[] args) {

        // create a thread pool of 2 threads
        // this is like a factory with 2 "workers"
        // We submit a set of tasks (more than the amount of "workers" (threads)) to the executor and "workers" start to execute the tasks
        // Once worker finishes one task, he gets the next one from the tasks list
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=0; i<5; i++) {
            // submit tasks to thread pool (5 tasks for 2 "workers"
            executor.submit(new Processor(i));
        }

        // waits for all tasks to be submitted
        executor.shutdown();
        System.out.println("All tasks submitted.");

        // waits for all tasks to be finished
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completted.");
    }

}
