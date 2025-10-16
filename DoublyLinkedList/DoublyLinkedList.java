package DoublyLinkedList;


public class DoublyLinkedList {
    //new Node to start the list
    Node head;
    
    //The rest of the methods will go beneath this line    
    public void addToHead(int element) {
        Node n = new Node(element);
        // the `next` of the new node, n, is now the head of the list
        n.next = head;
        //make the previous node null, since this will be the head
        n.prev = null;
        //previous of head is the new node, since the current `head` will now be the second item in list (following new node)
        if (head!= null) {
            head.prev = n;
        }
        //move the head point to new node
        head = n;
    }

    public void addToTail(int element) {
        Node n = new Node(element);
        Node end = head;
        n.next = null;
        // if list is empty, make new node the head
        if (head == null) {
            n.prev = null;
            head = n;
            return;
        }
        //go until you find the list
        while(end.next != null) {
            end = end.next;
        }
        //change next of last node
        end.next = n;
        //make last node the previous of new node
        n.prev = end;
    }

    public void insertNode(Node prev, int element) {
        //is the given Node null?
        if (prev == null) {
            System.out.println("Cannot have previous node of null");
            return;
        }
        //create new node and add date
        Node n = new Node(element);
        //make new node's next the next of the previous node
        n.next = prev.next;
        //make next of prev node, the new node
        prev.next = n;
        //make previous node as previous of new node
        n.prev = prev;
        //change previous of new nodes next node
        if(n.next != null) {
            n.next.prev = n;
        }
    }

    public void printList(Node node){
        System.out.println("Going forward --> ");
        Node end = null;
        while(node!=null) {
            System.out.print(node.data + " ");
            end = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("<-- Going backward ");
        while (end!= null) {
            System.out.print(end.data + " ");
            end = end.prev;
        }
    }
}
