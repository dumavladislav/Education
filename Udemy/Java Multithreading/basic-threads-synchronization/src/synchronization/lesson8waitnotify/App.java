package synchronization.lesson8waitnotify;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        /*
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.someOtherMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/

        t1.start();
        t2.start();
        //t3.start();

        t1.join();
        t2.join();
        //t3.join();

    }

}
