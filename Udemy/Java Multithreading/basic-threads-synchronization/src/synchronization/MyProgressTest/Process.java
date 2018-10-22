package synchronization.MyProgressTest;

public class Process {

    private volatile int processedItems = 0;
    private int iterations = 0;
    private final int totalItemsToProcess = 10000;
    Object locker = new Object();

    public void processItems() throws InterruptedException {
        while(processedItems < totalItemsToProcess) {
            processItem();
        }
    }

    public void processItem() throws InterruptedException {
        iterations++;
        if(processedItems < totalItemsToProcess) {
            synchronized (locker) {
                Thread.sleep(10);
                processedItems++;
                System.out.println("Amount of processed items: " + processedItems);
            }
        }
    }

    public int getIterations() {
        return iterations;
    }

    public void getProgress() throws InterruptedException {

        while(processedItems < totalItemsToProcess) {
            Thread.sleep(100);
            int progress = new Double((processedItems*1.0 / totalItemsToProcess) * 100).intValue();
            System.out.println("Current progress: " + progress);
        }
    }

}
