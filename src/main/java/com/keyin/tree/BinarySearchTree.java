package com.keyin.tree;

public class BinarySearchTree {

    private Node root;

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public int getValue() {
            return value;
        }
        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public void setRight(Node right) {
            this.right = right;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    public String JsonFormat() {
        if (root == null) {
            return "{}";
        }
        return "{\n\"root\":" + jsonFormatRecursive(root, 0) + "\n}";
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    private String jsonFormatRecursive(Node currentNode, int level) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        String indents = "  ".repeat(level + 1);
        jsonBuilder.append(indents).append("\"value\":").append(currentNode.getValue());


        if (currentNode.getLeft() != null) {
            jsonBuilder.append(",\n").append(indents).append("\"left\":").append(jsonFormatRecursive(currentNode.getLeft(), level + 1));
        } else {
            jsonBuilder.append(",\n").append(indents).append("\"left\":null");
        }

        if (currentNode.getRight() != null) {
            jsonBuilder.append(",\n").append(indents).append("\"right\":").append(jsonFormatRecursive(currentNode.getRight(), level + 1));
        } else {
            jsonBuilder.append(",\n").append(indents).append("\"right\":null");
        }

        jsonBuilder.append("\n").append("  ".repeat(level)).append("}");

        return jsonBuilder.toString();
    }

}
