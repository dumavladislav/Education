package synchronization.lesson11deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    Account acc1 = new Account();
    Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    //Another DEADLOCK Solution
    private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {

        while(true) {

            // Acquire locks

            boolean gotFirstLock = false;
            boolean gotSecondLock = false;

            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            }
            finally {
                if(gotFirstLock && gotSecondLock) {
                    return;
                }

                if(gotFirstLock) {
                    firstLock.unlock();
                }

                if(gotSecondLock) {
                    secondLock.unlock();
                }
            }

            // Locks not acquired
            Thread.sleep(1);

        }

    }

    public void firstThread() throws InterruptedException {

        Random random = new Random();

        for(int i=0; i<10000; i++) {
            // DEADLOCK - when we try to lock lock2 it is already locked by thread2.
            // lock1.lock();
            // lock2.lock();
            acquireLocks(lock1, lock2);

            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();

        for(int i=0; i<10000; i++) {

            // DEADLOCK - when we try to lock lock1 it is already locked by thread1.
            // One of the solutions - to lock the locks in the same order
            // lock2.lock();
            // lock1.lock();

            acquireLocks(lock2, lock1);


            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}