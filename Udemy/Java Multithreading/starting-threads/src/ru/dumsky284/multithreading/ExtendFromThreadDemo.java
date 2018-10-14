package ru.dumsky284.multithreading;

public class ExtendFromThreadDemo {

    public static void main(String[] args) {
        Runner runner1 = new Runner("Thread 1");
        runner1.start();    // if call run() directly, it will run the code in "run" method, but in the main thread

        Runner runner2 = new Runner("Thread 2");
        runner2.start();
    }

}
