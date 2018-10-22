package synchronization.lesson10reentrantlocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for(int i=0; i<10000; i++) {
            count++;
        }
    }

    public void firstThread() {
        lock.lock();

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

    public void secondThread() {
        lock.lock();
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
