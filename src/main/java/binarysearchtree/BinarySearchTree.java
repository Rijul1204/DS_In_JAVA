package binarysearchtree;

import java.util.Objects;

/**
 * Binary search implementation with primitive type
 *
 * @author Rashedul Hasan Rijul
 */
public class BinarySearchTree {

    private Node root;

    public void add(int value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        Node newNode = new Node(value);

        Node current = root;

        while (current != null) {

            if (current.value >= value) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            }
        }
    }

    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(Node root) {

        if (root == null) {
            return;
        }

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.value + " ");
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node root) {

        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public static void main(String args[]) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.add(1);
        tree.add(2);
        tree.add(6);
        tree.add(34);
        tree.add(5);
        tree.add(9);
        tree.add(5);
        tree.add(14);

        tree.printInOrder();
        tree.printPostOrder();
        tree.printPreOrder();

    }

    static class Node {

        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, left, right);
        }
    }
}

