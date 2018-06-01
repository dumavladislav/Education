import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    
    private Node<Item> firstItem;
    private Node<Item> lastItem;
    private int numberOfItems;
    
    private class Node<Item> {
        Item item;
        Node<Item> nextItem;
        Node<Item> prevItem;
    }
    
    public Deque() {                           // construct an empty deque
        numberOfItems = 0;
    }
    
    public boolean isEmpty() {                 // is the deque empty?
        if (numberOfItems == 0) return true;
        return false;
    }
    
    public int size() {                       // return the number of items on the deque
        return numberOfItems;
    }
    
    public void addFirst(Item item) {         // add the item to the front
        if (item == null) throw new IllegalArgumentException();
        
        Node<Item> oldFirst = firstItem;
        firstItem = new Node<Item>();
        firstItem.item = item;
        firstItem.nextItem = oldFirst;
        firstItem.prevItem = null;
        if (oldFirst != null)   oldFirst.prevItem = firstItem;
        if (lastItem == null)  lastItem = firstItem;
        numberOfItems++;
    }
    
    public void addLast(Item item) {           // add the item to the end
        if (item == null) throw new IllegalArgumentException();
        
        Node<Item> oldLast = lastItem;
        lastItem = new Node<Item>();
        lastItem.item = item;
        lastItem.nextItem = null;
        lastItem.prevItem = oldLast;
        if (oldLast != null) oldLast.nextItem = lastItem;
        if (firstItem == null)  firstItem = lastItem;
        numberOfItems++;
    }
    
    public Item removeFirst() {                // remove and return the item from the front
        if (isEmpty()) throw new NoSuchElementException();
        
        Node<Item> oldFirst = firstItem;        
        numberOfItems--;
        if (numberOfItems > 0) {
            firstItem = firstItem.nextItem;
            firstItem.prevItem = null;
        }
        else {
            firstItem = null;
            lastItem = null;
        }
        return oldFirst.item;        
    }
    
    public Item removeLast() {                 // remove and return the item from the end
        if (isEmpty()) throw new NoSuchElementException();
        numberOfItems--;
        Node<Item> oldLast = lastItem;
        if (numberOfItems > 0) {
            lastItem = lastItem.prevItem;
            lastItem.nextItem = null;
        }
        else {
            firstItem = null;
            lastItem = null;
        }
        return oldLast.item;
    }
    
    public Iterator<Item> iterator() {         // return an iterator over items in order from front to end
        return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item> {
        
        private Node<Item> current = firstItem; 
        
        @Override
        public boolean hasNext() {
            return current != null;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item currItemValue = current.item;
            current = current.nextItem;
            return currItemValue;
        }
        
    }
    
   
    public static void main(String[] args) {   // unit testing (optional)
        
        Deque<Integer> deq = new Deque<Integer>();
        /*
        System.out.println("Empty 1 = " + deq.isEmpty());
        System.out.println("Size 1 = " + deq.size());
        deq.addFirst(1);
        deq.addLast(2);
        deq.addLast(3);
        deq.addLast(-41);
        deq.addFirst(0);
        System.out.println("Empty 2 = " + deq.isEmpty());
        System.out.println("Size 2 = " + deq.size());
        
        deq.removeFirst();
        deq.removeLast();
        
        for (Integer val: deq) {
            System.out.println(val);
        }
        */
        
        deq.addFirst(0);
        deq.removeLast();
        
    }
}
