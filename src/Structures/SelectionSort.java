package Structures;
/**
 * the technique for sorting array
 * Selection sort isn't as good as Insertion sort as it takes constant time to sort
 * for best and worst cases
 * */
public class SelectionSort {

    /**
     * empty constructor
     * */
    public SelectionSort() {

    }

    /**
     * @param Comparable[] array -> generic array
     * @return Generic array, now sorted in ascending order
     *
     * @see exchange(Comparable[] array, int a, int b)
     *
     * we compare every point in array with its next ones until the inner loop ends
     * every time one point in array is less than the one which we compare, we put int min = j;
     *
     * @author Giorgi Meladze
     * */
    public static void sort(Comparable[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if (array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }

            exchange(array, i, min);
        }
    }

    private static void exchange(Comparable[] array, int a, int b) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * @param byte[] array
     * @return byte array, now sorted in ascending order
     *
     *
     * we compare every point in array with its next ones until the inner loop ends
     * every time one point in array is less than the one which we compare, we put int min = j;
     *
     * @author Giorgi Meladze
     * */
    public static void sort(byte[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            byte temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }

    /**
     * @param short[] array
     * @return short array, now sorted in ascending order
     *
     *
     * we compare every point in array with its next ones until the inner loop ends
     * every time one point in array is less than the one which we compare, we put int min = j;
     *
     * @author Giorgi Meladze
     * */
    public static void sort(short[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            short temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }

    /**
     * @param int[] array
     * @return int array, now sorted in ascending order
     *
     *
     * we compare every point in array with its next ones until the inner loop ends
     * every time one point in array is less than the one which we compare, we put int min = j;
     *
     * @author Giorgi Meladze
     * */
    public static void sort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }

    /**
     * @param long[] array
     * @return long array, now sorted in ascending order
     *
     *
     * we compare every point in array with its next ones until the inner loop ends
     * every time one point in array is less than the one which we compare, we put int min = j;
     *
     * @author Giorgi Meladze
     * */
    public static void sort(long[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            long temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }

    /**
     * @param float[] array
     * @return float array, now sorted in ascending order
     *
     *
     * we compare every point in array with its next ones until the inner loop ends
     * every time one point in array is less than the one which we compare, we put int min = j;
     *
     * @author Giorgi Meladze
     * */
    public static void sort(float[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            float temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }

    /**
     * @param double[] array
     * @return double array, now sorted in ascending order
     *
     *
     * we compare every point in array with its next ones until the inner loop ends
     * every time one point in array is less than the one which we compare, we put int min = j;
     *
     * @author Giorgi Meladze
     * */
    public static void sort(double[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            double temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }

    /**
     * @param char[] array
     * @return char array, now sorted in ascending order
     *
     *
     * we compare every point in array with its next ones until the inner loop ends
     * every time one point in array is less than the one which we compare, we put int min = j;
     *
     * @author Giorgi Meladze
     * */
    public static void sort(char[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            char temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

    }

}