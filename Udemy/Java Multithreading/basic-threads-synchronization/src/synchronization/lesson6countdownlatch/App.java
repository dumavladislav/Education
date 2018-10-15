package synchronization.lesson6countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        System.out.println("Started.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();

        System.out.println("Completted.");

    }
}

public class App {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(10);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i=0; i<10; i++) {
            executor.submit(new Processor(latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads completted.");

    }

}
