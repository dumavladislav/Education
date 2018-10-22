package synchronization.lesson2usingvariables;

import java.util.Scanner;

class Processor extends Thread {

    // please see explanation of "volatile" in the comment below. Prevents variable caching
    private volatile boolean keepRunning = true;

    @Override
    public void run() {

        while(keepRunning) {
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void shutDown() {
        keepRunning = false;
    }
}

public class TerminatingThreadUsingVariable {

    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        // example of terminating thread using variables
        System.out.println("Press return to stop.......");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        /*
        Java caching mechanism can prevent the process to stop. It doesn't expect keepRunning to be modified from the main thread
        So it can skip the change from the main thread.
        In order to avoid this kind of situation we add reserved word "volatile" to variable declaration in the child thread class
        */
        proc1.shutDown();

    }

}
