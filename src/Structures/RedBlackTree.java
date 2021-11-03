package Structures;

public class RedBlackTree<E extends Comparable<E>> extends BST{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public Node(E e) {
            this.e = e;
            color = RED;
        }
        E e;
        Node left, right;
        boolean color;
    }

    public boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node put(Node h, E e){
        if (h == null) return new Node(e);
        int cmp = e.compareTo(h.e);
        if (cmp < 0) h.left = put(h.left, e);
        else if (cmp > 0) h.right = put(h.right, e);

        if (isRed(h.right) && !isRed(h.left))  h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}
