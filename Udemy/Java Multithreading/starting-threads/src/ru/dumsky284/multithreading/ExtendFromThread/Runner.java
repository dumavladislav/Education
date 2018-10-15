package ru.dumsky284.multithreading.ExtendFromThread;

public class Runner extends Thread{

    private String threadId;

    Runner(String threadId) {
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
