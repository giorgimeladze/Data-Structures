package Structures;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * having Stack class which implements Iterable and is generic one
 * Here is impelemted Stack, one fo the most famous Data Collections, based on theory of Last in, Last out(LILO).
 *
 * @category Generic Data Structure
 * you can only add from  last one, and take the last one to be added.
 *
 * @author Giorgi Meladze
 * */

public class StackLinked<Type> implements Iterable<Type> {

    private Node first;
    private Node literallyFirst;
    private int size;

    private class Node {
        Node next;
        Type item;
    }

    public StackLinked() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * adding an element which shouldn't be of null type
     * */
    public void push(Type item) {
        NullArgument(item);

        if (size == 0) {
            literallyFirst = new Node();
            literallyFirst.item = item;
            first = literallyFirst;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
        }

        size++;
    }

    private void NullArgument(Type item) {
        if (item == null)
            throw new IllegalArgumentException();
    }

    /**
     * removing the last node of Stack collection and also getting the value which last one had
     * */
    public Type pop() {
        noElementCase();

        Type item = first.item;

        if (size > 1) {
            first = first.next;
        } else {
            first = null;
            literallyFirst = null;
        }

        size--;
        return item;
    }

    private void noElementCase() {
        if (size == 0)
            throw new NoSuchElementException();
    }

    /**
     * only getting the value of last piece of Stack without removing
     * */
    public Type peek() {
        noElementCase();

        Type item = first.item;
        return item;
    }


    @Override
    public Iterator<Type> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Type> {
        Node current = literallyFirst;

        /**
         * @return true if there is element left for iteration
         * */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * @return item of the Node current
         * */
        public Type next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Type item = current.item;
            current = current.next;
            return item;
        }
    }

}