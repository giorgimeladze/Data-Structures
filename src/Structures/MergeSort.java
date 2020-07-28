package Structures;
/**
 * Merge Sort, one of the greatest and fastest sorting algorihtms
 *
 * merge sort divides two halves of array , the recursively sorts both halves
 * after that, those two halves are merges into one sorted array
 *
 * @author Giorgi Meladze
 * */
public class MergeSort {

    private static Comparable[] temp;
    private static final int SIZE = 6;

    public MergeSort() {

    }

    /**
     * @param Comparable[] array -> generic array
     * @return Comparable array, now sorted in ascending order
     *
     * @see exchange(Comparable[] array, int a, int b)
     *
     *
     * @author Giorgi Meladze
     * */
    public static void sort(Comparable[] array) {
        temp = new Comparable[array.length];
        sort(array, temp, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, Comparable[] temp, int lo, int hi) {
        if (lo + SIZE >= hi) {
            InsertionSort.sort(array, lo, hi);
            return;
        }
        int mid = lo + (hi - lo)/2;

        sort(array,temp,lo,mid);
        sort(array,temp,mid+1,hi);
        merge(array,temp,lo,mid,hi);
    }

    /**
     * @param Comparable[] a, Comparable[] temp , int low, int mid, int hi;
     * no return type, only sorted array.
     *
     *
     * */
    private static void merge(Comparable[] array, Comparable[] temp, int lo, int mid, int hi) {

        for (int i = lo; i <= hi; i++) {
            temp[i] = array[i];            // copy
        }

        int i = lo; int j = mid + 1;
        for (int k = lo; k <= hi; k++) {   // merge
            if (i > mid)
                array[k] = temp[j++];
            else if (j > hi)
                array[k] = temp[i++];
            else if (temp[j].compareTo(temp[i]) < 0)
                array[k] = temp[j++];
            else
                array[k] = temp[i++];
        }

    }

    public static void toString(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
        }
    }

}