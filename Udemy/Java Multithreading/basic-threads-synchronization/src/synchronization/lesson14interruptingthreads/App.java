package synchronization.lesson14interruptingthreads;

import java.util.Random;

public class App {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting ...");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random ran = new Random();

                for(int i=0; i<1E8; i++) {

                    /*
                    // checking if the thread is interrupted
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted");
                        break;
                    }*/


                    // Another option. Previous - above
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                        break;
                    }

                    Math.sin(ran.nextDouble());
                }
            }
        });

        t1.start();

        Thread.sleep(500);

        // the thread is not stopped - it's just flagged to be interrupted
        t1.interrupt();

        t1.join();

        System.out.println("Finished");

    }

}
