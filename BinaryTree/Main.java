package BinaryTree;

public class Main {
//First, create a Node class
public static class Node {
//The left and right child of the current node are created,
//as well as the current node and its key value
int key;
Node left, right;
public Node(int item) {
key = item;
left = right = null;
}
}
public static class BinaryTree {
// Root
Node root;
BinaryTree(int key) {
root = new Node(key);
}
//constructor
BinaryTree() {
root = null;
}
}
//*********** MAIN ****************
public static void main(String[] args) {
//Create a binary tree
BinaryTree tree = new BinaryTree();
//Create Root
tree.root = new Node(1);
tree.root.left = new Node(2);
tree.root.right = new Node(3);
tree.root.left.left = new Node(4);
}
}