package CH11BST.BinaryTree;

import java.util.Scanner;

public class Main {
    // Class Node with the data and the child nodes
    class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
            leftChild = rightChild = null;
        }
    }

    // root node for the binary tree
    Node root;

    // Constructor method
    public Main() {
        root = null;
    }

    // Insert method for new values in the tree
    public void insert(int key) {
        root = insertNode(root, key);
    }

    // Insert recursive call for inserting from the root, in the right place
    public Node insertNode(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key <= node.data) {
            node.leftChild = insertNode(node.leftChild, key);
        } else if (key > root.data) {
            node.rightChild = insertNode(node.rightChild, key);
        }
        return node;
    }

    // Find method asking for the node to find
    public Node find(int key) {
        Node node = findNode(root, key);
        return node;
    }

    // Find recursive method using the root node.
    public Node findNode(Node node, int key) {
        // if the sarch key is found at this node, then return the node
        if (key == node.data) {
            return node;
        }
        // if the key is less than the node we are viewing, go left down the search tree (i.e., go
        // to node.leftChild)
        if (key <= node.data) {
            // if the left child node (node.leftChild) is null, then return null
            if (node.leftChild == null) {
                return null;
            } else { // otherwise,if its value is not null, return the next left child node
                return findNode(node.leftChild, key);
            }
        }
        // if the search key is > the node we are looking at, go right down the search tree
        else if (key > node.data) {
            // if the right child node is null, return null
            if (node.rightChild == null) {
                return null;
            } else { // otherwise, if not null, return the right child node
                return findNode(node.rightChild, key);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main binaryTree = new Main();
        // Asks the user to input 10 integers, and then inserts each user input into the binary tree
        for (int i = 0; i < 10; i++) {
            System.out.println("Please enter value " + (i + 1) + " for the binary tree: ");
            binaryTree.insert(scanner.nextInt());
        }

        // Collect user input to search for a node
        System.out.println("Please enter the node to search for: ");
        Node node = binaryTree.find(scanner.nextInt());
        // if node not found using .find()
        if (node == null) {
            System.out.println("The given number does not exist in the dataset.");
        } else { // if node found using .find()
            System.out.println("Node " + node.data + " was found in the dataset.");
        }
        scanner.close();
    }
}
