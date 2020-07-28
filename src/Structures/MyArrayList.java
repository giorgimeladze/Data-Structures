package Structures;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E> {
    private static final int INITIAL_CAPACITY = 16;
    private E[] arrayList = (E[]) new Object[INITIAL_CAPACITY];

    /**
     * empty constructor
     * */
    public MyArrayList() {

    }

    /**
     * Constructor with
     * @param Generic array which them is transfered as ArrayList
     * */
    public MyArrayList(E[] list) {
        for(int i = 0; i < list.length; i++) {
            add(list[i]);
        }
    }

    @Override
    /**
     *
     *public void add(int index, E e);
     *
     *This method adds a new element into arrayList at the given index
     *
     *@exception throws IndexOutOfBounds if the given index is a negative integer
     *@exception throws IllegalArgumentExcepiton if the Element argument/parameter is null pointer
     *
     *@see add(E e), which just adds element at the end of the array;
     * */
    public void add(int index, E e) {
        notNullArgument(e);
        indexCheck(index);

        if (size >= arrayList.length) {
            resize(2 * arrayList.length);
        }

        for (int i = size - 1; i >= index; i--) {
            arrayList[i + 1] = arrayList[i];
        }

        arrayList[index] = e;
        size++;
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
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }

    /**
     * resizing the array if array is full or only 1/4th of the whole array is filled
     * */
    private void resize(int length) {
        E[] copy = (E[]) new Object[length];
        for (int i = 0; i < size; i++) {
            copy[i] = arrayList[i];
        }
        arrayList = copy;
    }

    @Override
    /**
     * clearing the whole ArrayList from all elements
     * size assigning 0
     * */
    public void clear() {
        arrayList = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    /**
     * public boolean contains(E e)
     *
     * Checking through the whole array, if the given element exists
     * @return true if element is present is the list
     * */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(arrayList[i]))
                return true;
        }

        return false;
    }

    @Override
    /**
     * public E get(int index)
     *
     * @param int index
     * @return the element at the specified index
     *
     * @exception throws IndexOutOfBoundsException if index isn't in size parameter
     * */
    public E get(int index) {
        indexCheck(index);

        return arrayList[index];
    }

    @Override
    /**
     * public int indexOf(E e)
     *
     * getting the first occurence index from the specified element
     * @return -1 if no element exists in list
     * */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    /**
     * public int lastIndexOf(E e)
     *
     * returning the last occurence of the given element e
     * @return -1 if no element exists in the list
     * */
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(e))
                return i;
        }

        return -1;
    }

    @Override
    /**
     * public E remove(int index)
     *
     * removing the element from the given index and replacing other elements after removed one
     * @exception IndexOutOfBoundException if index isn't between 0 and size
     *
     * */
    public E remove(int index) {
        E temp = arrayList[index];

        if (index  == size - 1)
            return temp;

        for (int i = index; i < size; i++) {
            arrayList[i] = arrayList[i++];
        }

        arrayList[size - 1] = null;
        size--;

        if (size <= arrayList.length / 4)
            resize(arrayList.length/2);

        return temp;
    }

    @Override
    /**
     * public void set(int index, E e)
     *
     * Replacing the existing element on index with the specifiec parameter element
     *
     * throws IndexOutOfBounds if the given index is a negative integer
     * throws IllegalArgumentExcepiton if the Element argument/parameter is null pointer
     * */
    public void set(int index, E e) {
        indexCheck(index);
        notNullArgument(e);

        arrayList[index] = e;
    }

    @Override
    /**
     * public String toString()
     *
     * overriding Object class's method which prints out all the elements in the arrayList together
     * */
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");

        for (int i = 0; i < size; i++) {
            string.append(arrayList[i]);
            if (i < size - 1)
                string.append(",");
        }
        string.append("]");

        return string.toString();
    }

    public void trimToSize() {
        E[] temp = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = arrayList[i];
        }

        arrayList = temp;
    }

    @Override
    /**
     * Iterator is used to scan through the ArrayList
     *
     * @see public E next()
     * @see public boolean hasNext()
     * these two methods are in iterator
     * */
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int current;

        @Override
        /**
         * @return true if there is element left for iteration
         * */
        public boolean hasNext() {
            return current < size;
        }

        @Override
        /**
         * @return element at the current
         * */
        public E next() {
            return arrayList[current++];
        }
    }

}