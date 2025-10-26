// File: StackOperations.java
// Package: StackOperations (optional; you can omit the package line if not using folders)

package StackOperations;

import java.util.NoSuchElementException;

// Stack interface defining push, pop, peek, size, and isEmpty methods
interface Stack {
    void push(int plate);        // Add an item to the top
    int pop();                   // Remove the top item
    int peek();                  // Look at the top item without removing
    int size();                  // Return number of elements
    boolean isEmpty();           // Check if stack is empty
}

// LinkedStack class implementing the Stack interface
class LinkedStack implements Stack {

    // Node inner class representing each element in the stack
    private class Node {
        int plate;
        Node next;
        public Node(int current) {
            plate = current;
        }
    }

    private Node top; // The top of the stack

    // Constructor initializes an empty stack
    public LinkedStack() {
        top = null;
    }

    // Push adds a new item to the top
    public void push(int current) {
        Node c = new Node(current);
        c.next = top;
        top = c;
    }

    // Pop removes and returns the top item
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        int returnPlate = top.plate;
        top = top.next;
        return returnPlate;
    }

    // Peek looks at the top item without removing it
    public int peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.plate;
    }

    // Returns true if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Returns the number of elements in the stack
    public int size() {
        int counter = 0;
        for (Node node = top; node != null; node = node.next) {
            counter++;
        }
        return counter;
    }
}

// Main class with demonstration
public class StackOperations {
    public static void main(String[] args) {
        int plate;
        LinkedStack lottaPlates = new LinkedStack();

        // Push some plates onto the stack
        plate = 25;
        for (int i = plate; i < 150; i++) {
            lottaPlates.push(i + 5);
        }

        // Check if empty
        if (lottaPlates.isEmpty()) {
            System.out.println("Empty Stack");
        } else {
            // Peek, show size, and pop top
            System.out.println("Peeking at the top = " + lottaPlates.peek());
            System.out.println("Size of the stack = " + lottaPlates.size());
            System.out.println("Popping the top = " + lottaPlates.pop());
        }

        // Remove plates until the 50th one remains
        for (int j = lottaPlates.size(); j >= 50; j--) {
            System.out.println("Current size before pop: " + lottaPlates.size());
            lottaPlates.pop();
        }
    }
}
