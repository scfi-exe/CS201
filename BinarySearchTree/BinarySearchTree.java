package BinarySearchTree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BinarySearchTree {

    // static class for nodes within the BST
    private static class Node {
        int key;
        Node left, right;
        Node(int k) { key = k; }
    }
    
    // class for the binary search tree and its related behaviors   
    private static class BST {
        private Node root;

        public void clear() { root = null; }

        // Insert, ignore duplicates
        public void insert(int key) {
            root = insertRec(root, key);
        }

        private Node insertRec(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.key) {
                node.left = insertRec(node.left, key);
            } else if (key > node.key) {
                node.right = insertRec(node.right, key);
            } // else equal -> then, ignore
            return node;
        }

        // Delete (if not found, this does nothing)
        public void delete(int key) {
            root = deleteRec(root, key);
        }

        private Node deleteRec(Node node, int key) {
            if (node == null) return null;

            if (key < node.key) {
                node.left = deleteRec(node.left, key);
            } else if (key > node.key) {
                node.right = deleteRec(node.right, key);
            } else {
                // Found node: 3 cases
                if (node.left == null && node.right == null) {
                    return null; // leaf
                } else if (node.left == null) {
                    return node.right; // only right child
                } else if (node.right == null) {
                    return node.left; // only left child
                } else {
                    // two children: replace with inorder successor
                    Node succ = minNode(node.right);
                    node.key = succ.key;
                    node.right = deleteRec(node.right, succ.key);
                }
            }
            return node;
        }

        private Node minNode(Node node) {
            while (node != null && node.left != null) {
                node = node.left;
            }
            return node;
        }

        // Traversals
        public void printInOrder() {
            inOrder(root);
            System.out.println();
        }
        private void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }

        public void printPreOrder() {
            preOrder(root);
            System.out.println();
        }
        private void preOrder(Node node) {
            if (node == null) return;
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        public void printPostOrder() {
            postOrder(root);
            System.out.println();
        }
        private void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }

        // Build the exact balanced tree for a preset tree (1, 2, 3, 4, 5, 6, 7) (based on the assignment prompt)
        public void buildPresetBalanced1to7() {
            clear();
            int[] order = {4, 2, 6, 1, 3, 5, 7};
            for (int v : order) insert(v);
        }
    }

    // Console/Menu UI for the User Interface
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST();
        boolean running = true;

        System.out.println("Binary Search Tree (User Interface)");

        while (running) {
            printMenu();
            int choice = readInt(sc, "Choose an option (1-7): ");

            switch (choice) {
                case 1:
                    tree.buildPresetBalanced1to7();
                    System.out.println("Created balanced BST with nodes: 1 2 3 4 5 6 7");
                    break;
                case 2: {
                    int val = readInt(sc, "Enter integer to add: ");
                    tree.insert(val);
                    System.out.println("Inserted " + val + ".");
                    break;
                }
                case 3: {
                    int val = readInt(sc, "Enter integer to delete: ");
                    tree.delete(val);
                    System.out.println("Deleted " + val + " (if it existed).");
                    break;
                }
                case 4:
                    System.out.print("InOrder: ");
                    tree.printInOrder();
                    break;
                case 5:
                    System.out.print("PreOrder: ");
                    tree.printPreOrder();
                    break;
                case 6:
                    System.out.print("PostOrder: ");
                    tree.printPostOrder();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a number 1-7.");
            }
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n~~~~~~~~ BST MENU ~~~~~~~~");
        System.out.println("1) Create a binary search tree");
        System.out.println("2) Add a node");
        System.out.println("3) Delete a node");
        System.out.println("4) Print nodes by InOrder");
        System.out.println("5) Print nodes by PreOrder");
        System.out.println("6) Print nodes by PostOrder");
        System.out.println("7) Exit program");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine(); // clear bad token
            }
        }
    }
}
