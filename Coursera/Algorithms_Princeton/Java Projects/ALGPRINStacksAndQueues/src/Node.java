public class Node <ItemType>{
    private ItemType item;
    private Node nextItem;
    
    public void setItem(ItemType item) {
        this.item = item;
    }
    
    public void setNextItem(Node nextItem) {
        this.nextItem = nextItem;
    }
    
    public ItemType getItem() {
        return item;
    }
    
    public Node getNextItem() {
        return nextItem;
    }
    
}
