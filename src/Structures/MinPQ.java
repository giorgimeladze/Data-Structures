package Structures;

public class MinPQ<E extends Comparable<E>> {
    private int size = 0;
    private E[] array;

    public MinPQ() {
        array = (E[]) new Comparable[17];
    }

    public MinPQ(int capacity) {
        array = (E[]) new Comparable[capacity+1];
    }

    public int size() {
        return size;
    }

    private void resize(int length) {
        E[] copy = (E[]) new Comparable[length];
        for (int i = 0; i <= size; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(E e) {
        if (size == array.length) {
            resize(size*2);
        }
        array[++size] = e;
        swim(size);
    }

    public E delMin() {
        exch(1,size);
        E min = array[size--];
        array[size + 1] = null;
        sink(1);
        if (size == array.length / 4) {
            resize(size/2);
        }
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k/2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while(2*k <= size) {
            int j = 2 * k;
            if (j < size && greater(j,j+1))  j++;
            if (!greater(k,j))  break;
            exch(k,j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return array[i].compareTo(array[j]) > 0;
    }

    private void exch(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("[");
        for (int i = 1; i <= size; i++) {
            string.append(array[i]);
            if (i < size)
                string.append(",");
        }
        string.append("]");

        return string.toString();
    }

    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>();
        pq.insert(23);
        pq.insert(45);
        pq.insert(453);
        pq.insert(21);
        pq.insert(87);
        pq.insert(50);
        pq.insert(34);
        pq.insert(22);
        System.out.println(pq.toString());
        System.out.println(pq.delMin());
    }

}