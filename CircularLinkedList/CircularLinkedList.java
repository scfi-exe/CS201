package CircularLinkedList;


import java.util.*;
public class CircularLinkedList {
    public int size=0;
    public Node head = null;
    public Node tail = null;
    //print the list
    public void print(){
        System.out.println("The List So Far: ");
        if (head == null) {
            System.out.println("(Empty)");
            return;
        }
        
        Node temp = head;
        do {
            System.out.println(" " + temp.element);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // add a new node at the start of the linked list
    public void addNodeToHead(int element) {
    Node n = new Node(element);
    if (size == 0) {
        head = n;
        tail = n;
        n.next = head;
    } else {
        Node temp = head;
        n.next = temp;
        head = n;
        tail.next = head;
    }
    size++;
    }

    // defining method to add a node to the tail
    public void addNodeToTail(int element) {
        if (size == 0) {
            addNodeToHead(element);
        }else{
            Node n = new Node(element); //create new Node
            tail.next = n; // set the tail's pointer to the new node
            tail = n; // set the tail to the new node
            tail.next = head; // set the new tail's pointer, to the header
            size++; // increase the size of the list by 1
        }
    }

    public void rotateElement() {
        System.out.println("Rotating!");
        tail = head;
        head = head.next;
    }

    public void deleteNodeFromTail() {
        System.out.println("\nDeleting Note " + tail.element + "from Tail");
        if(tail.next == tail) { 
            tail = null;
        }
        Node newTail = tail;
        while (newTail.next != tail) {
            newTail = newTail.next;
        }
        newTail.next = tail.next;
        tail = newTail;
        size--;
    }

    public void deleteNodeFromHead() {
        head = head.next;
        tail.next = head;
        size--;
    }
}
