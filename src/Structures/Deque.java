package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Giorgi Meladze
 * this is my written Dequeue Data structure
 *
 * @category Data structure
 * you can add from the beginning and from the end
 * you can remove from last and first parts
 *
 * The combination of Stack and Queue
 */
public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node first, last;

    /**
     * creating Node class, so that we can have Deque
     * made in LinkedList
     * */
    private class Node {
        Node next;
        Node previous;
        Item item;
    }

    // creating empty constructor
    public Deque() {

    }

    /**
     * checking if Dequeue is empty
     * */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * getting size of Dequeue
     * */
    public int size() {
        return size;
    }

    /**
     * adding the first element
     * if size = 0, then we point Node last to first's object
     * so that they will point to same object
     * @param item
     *
     * */
    public void addFirst(Item item) {
        notNullArgument(item);

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (size > 0)
            oldFirst.previous = first;
        else
            last = first;

        size++;
    }

    /**
     * throws illegal argument if @param is null
     * */
    private void notNullArgument(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
    }

    /**
     * @param item
     *
     * adding the last element to Dequeue
     * if size = 0, then we point Node first to last's object
     * so that they will point to same object
     * */
    public void addLast(Item item) {
        notNullArgument(item);

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.previous = oldLast;
        if (size > 0)
            oldLast.next = last;
        else
            first = last;

        size++;
    }

    /**
     * removing the first item from Dequeue
     *
     * if size = 1, the removing element will make size = 0
     * in such case both first and last = null
     * */
    public Item removeFirst() {
        noElementCase();

        Item item = first.item;
        if (size > 1) {
            first = first.next;
        } else {
            first = null;
            last = null;
        }

        size--;
        return item;
    }

    /**
     * throws exception if we try to remove element when size is 0
     * */
    private void noElementCase() {
        if (size == 0)
            throw new NoSuchElementException();
    }

    /**
     * removing last item from Dequeue
     *
     * if size = 1, then both first and last will be null
     * */
    public Item removeLast() {
        noElementCase();

        Item item = last.item;
        if (size > 1) {
            last = last.previous;
        } else {
            first = null;
            last = null;
        }

        size--;
        return item;
    }

    /**
     * making iterator with
     * @return DequeIterator
     * */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    /**
     * creating private class for iteration with 3 methods
     * */
    private class DequeIterator implements Iterator<Item> {
        Node current = first;

        /**
         * @return true if there is element left for iteration
         * */
        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException(); // we don't want this method to be called
        }

        /**
         * @return item of the Node current
         * */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}