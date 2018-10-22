package ru.dumsky284.multithreading.ImplementRunnable;

class RunnerImpl implements Runnable {

    private String threadId;

    RunnerImpl(String threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(threadId + " Saying \"Hello\" " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ImplementRunnableDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnerImpl("Thread 1"));
        Thread t2 = new Thread(new RunnerImpl("Thread 2"));
        t1.start();
        t2.start();

    }
}
