package Structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node first, last;

    private class Node {
        Node next;
        E element;
    }

    /**
     * empty linked list
     * */
    public MyLinkedList() {

    }

    /**
     * creating linked list from already existing generic array
     * copying all elements into linked list
     * */
    public MyLinkedList(E[] list) {
        super(list);
    }

    @Override
    /**
     * public void add(int index, E e)
     * adding element at the given index
     * */
    public void add(int index, E e) {
        notNullArgument(e);
        indexCheckForAdding(index);

        if (size == 0) {
            addFirst(e);
        } else if (size == index) {
            addLast(e);
        } else {
            Node current = first;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next;  // assigning temp to old index element
            current.next = new Node(); // creating new index-th element
            current.next.element = e;  // assigning element e to the index-th
            (current.next).next = temp;// assigning new index-th element's next pointer to the old one
            size++;
        }

    }

    /**
     * throws illegal argument if @param is null
     * */
    private void notNullArgument(E e) {
        if (e == null)
            throw new IllegalArgumentException();
    }

    /**
     * checking if index is correctly given as it should be between 0 and size
     * */
    private void indexCheck(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private void indexCheckForAdding(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    /**
     * adding element at the head of linked list
     * adding element so increasing
     * */
    public void addFirst(E e) {
        notNullArgument(e);

        if (size == 0) {
            first = new Node();
            first.element = e;
            last = first;
            size++;
        } else if (size == 1) {
            first = new Node();
            first.element = e;
            first.next = last;
            size++;
        } else {
            Node oldFirst = first;
            first = new Node();
            first.element = e;
            first.next = oldFirst;
            size++;
        }
    }

    /**
     * adding element at the tail of linked list
     * adding element so increasing size by 1
     * */
    public void addLast(E e) {
        notNullArgument(e);

        if (size == 0) {
            last.element = e;
            first = last;
            size++;
        } else if (size == 1) {
            last = new Node();
            last.element = e;
            first.next = last;
            size++;
        } else {
            Node oldLast = last;
            last = new Node();
            last.element = e;
            oldLast.next = last;
            size++;
        }
    }

    /**
     * getting the first element
     * */
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return first.element;
        }
    }

    /**
     * getting the last element
     * */
    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return last.element;
        }
    }

    @Override
    /**
     * getting rid of everything
     * */
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    /**
     * outposting every element of linked list
     * */
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node current = first;

        string.append("[");
        for (int i = 0; i < size; i++) {
            string.append(current.element);
            current = current.next;
            if (current != null)
                string.append(",");
        }

        string.append("]");
        return string.toString();
    }

    @Override
    /**
     * checks if given element is present in linked list
     * */
    public boolean contains(E e) {
        notNullArgument(e);
        Node current = first;

        for (int  i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    /**
     * getting element at the given index
     * */
    public E get(int index) {
        indexCheck(index);

        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.element;
    }

    @Override
    /**
     * index of given element e
     * */
    public int indexOf(E e) {
        notNullArgument(e);

        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                return i;
            current = current.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        notNullArgument(e);

        int index = -1;
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e))
                index = i;
            current = current.next;
        }

        return index;
    }

    @Override
    /**
     * removing element at the given index
     * throwing exception if index is wrongly given
     * */
    public E remove(int index) {
        indexCheck(index);

        if (size == 0)
            return null;
        else if (size == 1)
            return removeFirst();
        else if (index == size - 1)
            return removeLast();
        else {
            Node temp = first;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }

            Node node = temp.next;
            temp.next = node.next;
            size--;
            return node.element;
        }
    }

    /**
     * remove the first element of list, decreasing its size also
     * */
    public E removeFirst() {
        if (size == 0)
            return null;

        E element = first.element;
        if (size > 1) {
            first = first.next;
        }
        if (size == 1){
            first = null;
            last = null;
        }
        size--;

        return element;
    }

    /**
     * removing the last element of the linked list
     * */
    public E removeLast() {
        if (size == 0)
            return null;
        E element = last.element;

        if (size == 1) {
            first = null;
            last = null;
        } else if(size > 1) {
            Node current = first;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            last = current;
            last.next = null;
        }

        size--;
        return element;
    }

    @Override
    /**
     * change element in index to given e
     * */
    public void set(int index, E e) {
        indexCheck(index);
        notNullArgument(e);

        Node current = first;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }

        current.element = e;

    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

    }

}