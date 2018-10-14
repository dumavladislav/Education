import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    
    public static void main(String[] args) {
        
        RandomizedQueue<String> randQueue = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            randQueue.enqueue(StdIn.readString());
        }
        /*    
        for (String s : inputStr.split(" ")) {
            System.out.println(s);
            randQueue.enqueue(s);
        }
        */
        for (int i = 0; i < k; i++) {
            System.out.println(randQueue.dequeue());
        }
        
    }

}
