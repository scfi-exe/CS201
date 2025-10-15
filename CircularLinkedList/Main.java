package CircularLinkedList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();
        myList.addNodeToHead(75);
        myList.addNodeToHead(50);
        myList.addNodeToHead(25);
        myList.addNodeToTail(100);
        myList.print();
        myList.rotateElement();
        myList.print();
        myList.deleteNodeFromTail();
        myList.print();
    }
}
