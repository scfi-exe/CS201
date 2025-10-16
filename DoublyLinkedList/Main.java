package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        //creates the list
        DoublyLinkedList dll = new DoublyLinkedList();
        //add item to head
        dll.addToHead(50);
        //add item to tail
        dll.addToTail(100);
        //list should now be 50 -> 100 -> null
        //add item to head
        dll.addToHead(25);
        //list is 25->50->100
        dll.insertNode(dll.head.next,75);
        //print
        dll.printList(dll.head);
    }
}
