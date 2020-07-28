package Structures;
/**
 * To sort arrays
 * Bubble Sort is one type of sorting , which isn't perfect, but good for small arrays
 *
 * @author Giorgi Meladze
 * */
public class BubbleSort {

    /**
     * empty constructor
     * */
    public BubbleSort() {

    }

    /**
     * public static void sort(Comparable[] array){
     * }
     *
     * @param Comparable[] array, one with compareTo() method
     *
     * @return Comparable array, but now sorted in ascending order
     *         for every object which has defined compareTo() method
     *
     * @see exchange(Comparable[] array, int first, int second)
     *
     * we sort the array in multiple phases. each phase compares the neighboring elements and if necessary swaps them
     * until the whole array isn't in ascending order.
     * with each phase the length of elements for comparing is decreased by one as the remaing elements at the back are already sorted
     *
     * @see notSorted is used. If element is already sorted, we don't need to comtinue comparing, so notSorted = false will terminate the loop
     * and return the sorted array we need
     *
     * @author Giorgi Meladze
     * */
    public static void sort(Comparable[] array) {
        int N = array.length;
        boolean notSorted = true;

        for (int i = 1; i < N && notSorted; i++) {
            notSorted = false;

            for (int k = 0; k < N - i; k++) {
                if (array[k+1].compareTo(array[k]) < 0) {
                    swap(array, k+1, k);
                    notSorted = true;
                }
            }

        }
    }

    private static void swap(Comparable[] a, int b, int c) {
        Comparable temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }
}