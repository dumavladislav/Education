package synchronization.MyProgressTest;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Process proc = new Process();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        proc.processItems();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        proc.processItems();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    proc.getProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Amount of iterations: " + proc.getIterations());

    }

}
