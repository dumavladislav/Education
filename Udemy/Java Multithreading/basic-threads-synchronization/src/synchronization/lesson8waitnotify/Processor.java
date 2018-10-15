package synchronization.lesson8waitnotify;

import java.util.Scanner;

public class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread running ....");

            // wait() is a Object class method so all objects have this method
            // wait can only be used in synchronized block
            // when wait() is called the thread loses the control over the locked object
            // it waits until the object is released by calling of notify() method from another thread
            wait();
            System.out.println("Producer resumed.");
            //notify(); - My test to notify someOtherMethod in case produce() resumed after consume() sent notification
        }
    }

    public void consume() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");

            // notify can only be used in synchronized block
            // it notifies all threads waiting for the same locked object
            // and tells them that the object is released and it's time to wake up
            notify();

            // but notify is just a notification
            // the waiting thread will not resume until this block of code is finished
            Thread.sleep(5000);
        }
    }

    // MY TEST
/*    public void someOtherMethod() throws InterruptedException {

        synchronized (this) {
            System.out.println("someOtherMethod thread running...");
            wait();
            System.out.println("someOtherMethod resumed.");
            //notify(); - My test to notify produce() in case someOtherMethod() resumed after consume() sent notification
        }

    }*/

}
