package Algorithms.RedBlackTree;

public class LeftRedBlackTree {

    private Node root;

    public boolean add(int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Node.Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Node.Color.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Node.Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Node.Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Node.Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Node.Color.BLACK)) {
                needRebalance = true;
                result = rigthSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Node.Color.RED &&
                    (result.leftChild.leftChild != null && result.leftChild.leftChild.color == Node.Color.RED)) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Node.Color.RED &&
                    (result.rightChild != null && result.rightChild.color == Node.Color.RED)) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    private Node rigthSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Node.Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Node.Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.rightChild.color = Node.Color.BLACK;
        node.leftChild.color = Node.Color.BLACK;
        node.color = Node.Color.RED;
    }

    private class Node {
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }

        private enum Color {
            RED, BLACK
        }
    }
}
