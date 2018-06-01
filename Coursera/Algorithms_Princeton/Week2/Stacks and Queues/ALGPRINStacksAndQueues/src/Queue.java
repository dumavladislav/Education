
public class Queue<ItemType> implements Storage<ItemType> {

    private Node firstNode;
    private Node lastNode;
    
    /*
     * QUEUE: firsts -> ..... -> last
     * 
     * 
     */
    Queue(){
        firstNode = null;
        lastNode = null;
    }
    
    
    @Override
    public ItemType pop() {
        Node<ItemType> oldFirstNode = firstNode;
        firstNode = firstNode.getNextItem();
        return oldFirstNode.getItem();
    }

    @Override
    public int push(ItemType item) {
        Node oldLastNode = lastNode;
        lastNode = new Node();
        lastNode.setItem(item);
        if(oldLastNode != null) oldLastNode.setNextItem(lastNode);
        else firstNode=lastNode;
        return 0;
    }

}
