package synchronization.lesson12semaphores;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Connection {

    /*
    Singletone class
     */

    private static Connection instance = new Connection();
    private int connections = 0;
    private Semaphore sem = new Semaphore(20 ,true);  // limit the number of connections

    private Connection() {

    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doConnect();
        }
        finally {
            sem.release();
        }
    }

    public void doConnect() {



        synchronized(this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }

    }

}
