package Structures;

/**
 * To sort arrays using Comparable[]
 * Insertion sort is one type of sorting , which isn't perfect, but good for small arrays
 *
 * @author Giorgi Meladze
 * */
public class InsertionSort  {

    /**
     * empty InsertionSort constructor
     * */
    public InsertionSort() {

    }

    /**
     * public static void sort(Comparable[] array){
     * }
     *
     * @param Item[] array, generic array
     * @return Generic array, but know sorting in ascending order
     *         for every object which has defined compareTo() method
     * @see exchange(Comparable[] array, int first, int second)
     *
     * we compare every point in array with its previous ones until it's bigger than compared, then we move on to the next index
     * every time one point in array is less than its previous one, we exchange their places with private method
     *
     * @author Giorgi Meladze
     * */
    public static void sort(Comparable[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j].compareTo(array[j-1]) < 0) {
                    exchange(array,j,j-1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * public static void sort(Comparable[] array, int lo, int hi){
     * }
     *
     * @param Comparable[] array, which has compareTo() method; int lowest index, int highest index
     * @return Comparable array, but know sorted in ascending order
     *         for every object which has defined compareTo() method
     * @see exchange(Comparable[] array, int first, int second)
     *
     * we compare every point in array with its previous ones until it's bigger than compared, then we move on to the next index
     * every time one point in array is less than its previous one, we exchange their places with private method
     *
     * @author Giorgi Meladze
     * */
    public static void sort(Comparable[] array, int lo, int hi) {

        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (array[j].compareTo(array[j-1]) < 0) {
                    exchange(array,j,j-1);
                } else {
                    break;
                }
            }
        }
    }

    private static void exchange(Comparable[] array, int num1, int num2) {
        Comparable temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

}