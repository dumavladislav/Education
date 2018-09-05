
public class Stack <ItemType> implements Storage<ItemType>{
    
    Node<ItemType> firstItem;
    private int itemsCount;
    
    public Stack() {
        itemsCount = 0;
    }
    
    @Override
    public ItemType pop() {
        Node<ItemType> poppedItem = firstItem;
        firstItem = firstItem.getNextItem();
        itemsCount--;
        return poppedItem.getItem();
    }

    @Override
    public int push(ItemType item) {
        itemsCount++;
        Node oldFirst = firstItem;
        firstItem = new Node<ItemType>();
        firstItem.setItem(item);
        firstItem.setNextItem(oldFirst);
        return itemsCount;
    }
    

    
}
