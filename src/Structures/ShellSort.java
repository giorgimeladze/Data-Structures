package Structures;

public class ShellSort {

    public ShellSort() {

    }
    /**
     * @param Comparable[] array -> generic array
     * @return Generic array, now sorted in ascending order
     *
     * @see exchange(Comparable[] array, int a, int b)
     *
     * we compare every point in array with its previos one which is less by given h integer, until the inner loop ends
     * every time one point in array is less than the one which we compare, we exchange them
     *
     * @author Giorgi Meladze
     * */
    public static void sort(Comparable[] array) {
        int length = array.length;

        int gap = 1;

        while ( gap < length/3) {
            gap = 3*gap + 1;
        }

        while (gap >= 1) {

            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && array[j].compareTo(array[j-gap]) < 0; j-=gap ) {
                    exchange(array, j, j-gap);
                }
            }

            gap = gap/3;
        }
    }


    private static void exchange(Comparable[] a, int j, int b) {
        Comparable temp = a[j];
        a[j] = a[b];
        a[b] = temp;
    }

}