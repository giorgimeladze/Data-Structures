package Structures;

/* These sort is to be applied to primitive numbers and Comparable ones
        *
        * @author Giorgi Meladze
        * */
public class QuickSort {
    private static final int SIZE = 6;

    public QuickSort() {

    }

    public static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int lo, int hi) {
        if (lo + SIZE >= hi) {
            InsertionSort.sort(array, lo, hi);
            return;
        }
        int part = partition(array, lo,hi );
        sort(array, lo, part - 1);
        sort(array, part + 1,hi);
    }

    private static int partition(Comparable[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while(array[++i].compareTo(array[lo]) < 0) {    //find item on left to swap
                if (i == hi) break;
            }
            while (array[lo].compareTo(array[--j]) < 0) {   //find item on right to swap
                if (j == lo) break;
            }
            if (i >= j) break;                              // check if pointers cross
            exch(array, i, j);                              // swap
        }

        exch(array, lo, j);                                     // swap with partitionig item
        return j;                                          //return index of item known to be in place
    }

    private static void exch(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = array[i];
    }
}