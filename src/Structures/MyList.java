package Structures;

public interface MyList<E> extends Iterable<E> {
    /**
     * Returns the size of a List
     * */
    public int size();

    /**
     * adding element at the end of the arraylist or linkedlint
     * */
    public void add(E e);

    /**
     * adding element at the given index
     * */
    public void add(int index, E e);

    /**
     * Returns true if there is no element in the list,
     * That is when size == 0
     * */
    public boolean isEmpty();

    /**
     * Deletes all the elements in the list, making it empty
     * */
    public void clear();

    /**
     * Checks if the given element is present in the list
     * */
    public boolean contains(E e);

    /**
     * return the element at the given index
     * */
    public E get(int index);

    /**
     * Removes the element given as a parameter
     * if there is no such element in list, @return false
     * */
    public boolean remove(E e);

    /**
     * getting index of the given element
     * */
    public int indexOf(E e);

    /**
     * get last index of element e
     * */
    public int lastIndexOf(E e);

    /**
     * removes the element at the given index
     * */
    public E remove(int index);

    /**
     * replaces the present element at index with element which is in parameter
     * */
    public void set(int index, E e);

}