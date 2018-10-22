package synchronization.lesson3synchronizedword;

public class SuncUsingWordSynchronized {

    private int count = 0;

    /*
    synchronized method can be executed only by one thread at a time for a given object (class instance)
    because before executing it tries to read transit log (or monitor log) of the object. And only one thread is allowed to do it
    */
    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {

        SuncUsingWordSynchronized app = new SuncUsingWordSynchronized();
        app.doWork();

    }

    public void doWork() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Count is: " + count);

    }

}
