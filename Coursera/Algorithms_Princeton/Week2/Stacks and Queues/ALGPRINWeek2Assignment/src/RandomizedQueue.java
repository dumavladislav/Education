import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    private Item[] storage;
    private int numOfItems;
    
    public RandomizedQueue() {                 // construct an empty randomized queue
        storage = (Item[]) new Object[50];
        numOfItems = 0;
    }
    
    private void resize(int newSize) {
        Item[] newStor = (Item[]) new Object[newSize];
        for (int i = 0; i < numOfItems; i++) {
            newStor[i] = storage[i];
        }
        storage = newStor;
    }
    
    private void shrinkArray() {
        if (numOfItems > 0 && numOfItems == storage.length/4) resize(storage.length/2);
    }
    
    public boolean isEmpty() {                 // is the randomized queue empty?
        if (numOfItems == 0) return true;
        return false;
    }
    
    public int size() {                        // return the number of items on the randomized queue
        return numOfItems;
    }

    public void enqueue(Item item) {           // add the item
        if (item == null) throw new IllegalArgumentException();
        
        storage[numOfItems] = item;
        
        numOfItems++;
        if (numOfItems >= storage.length) resize(storage.length*2);
    }

    public Item dequeue() {                    // remove and return a random item
        
        if (isEmpty()) throw new NoSuchElementException();
        
        int randCounter = StdRandom.uniform(numOfItems)+1;
 
        Item tempItem = storage[randCounter-1];
        storage[randCounter-1] = storage[numOfItems-1];

        numOfItems--;
        if (numOfItems <= storage.length/4) shrinkArray();
        return tempItem;
    }
    
    public Item sample() {                     // return a random item (but do not remove it)
        if (isEmpty()) throw new NoSuchElementException();
        
        int randCounter = StdRandom.uniform(numOfItems)+1;
        return storage[randCounter-1];
    }

    public Iterator<Item> iterator() {         // return an independent iterator over items in random order
        return new RandomizedQueueIterator();
    }
    
    private class RandomizedQueueIterator implements Iterator<Item> {
        
        int current = 0;
        int[] indexes;
        
        RandomizedQueueIterator() {
            indexes = new int[numOfItems];
            for (int i = 0; i < numOfItems; i++)
                indexes[i] = i;
            StdRandom.shuffle(indexes);
        }
        
        public boolean hasNext() {
            if (current < indexes.length) return true;
            return false;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item oldCurrent = storage[indexes[current]];
            current++;
            return oldCurrent;        
        }
        
    }

    public static void main(String[] args) {   // unit testing (optional)
        
        RandomizedQueue<Integer> randQueue = new RandomizedQueue<Integer>();
        
        randQueue.enqueue(1);
        randQueue.enqueue(2);
        randQueue.enqueue(3);
        randQueue.enqueue(4);
        randQueue.enqueue(5);
        randQueue.enqueue(6);
        randQueue.enqueue(7);
        randQueue.enqueue(8);
        
        System.out.println(randQueue.dequeue());
        System.out.println(randQueue.dequeue());
        System.out.println(randQueue.dequeue());
        System.out.println(randQueue.dequeue());
        System.out.println(randQueue.dequeue());
        
        System.out.println("REMAINING SIZE = " + randQueue.size());        
        
        
        System.out.println(randQueue.dequeue());
    }
}
