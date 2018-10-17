package synchronization.lesson10reentrantlocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerWithCondition {

    private int count = 0;

    private Lock lock = new ReentrantLock();

    // Condition is a class that allows to use await() and signal() - analogues of wait() and notify()
    private Condition cond = lock.newCondition();

    private void increment() {
        for(int i=0; i<10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting...");

        // await() is an analogue of wait()
        cond.await();
        System.out.println("Woken up!");

        /*
        We are adding try block in order to avoid situation when increment() throws an exception and we never unlock the resource
         */
        try {
            increment();
        }
        finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {

        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key!");

        // signal() is an analogue of notify()
        // even when we called signal(), we still need to unlock the object before firstThread is actually awake
        cond.signal();

        try {
            increment();
        }
        finally {
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }

}
