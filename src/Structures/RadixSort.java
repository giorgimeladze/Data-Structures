package Structures;

public class RadixSort {

    public RadixSort() {

    }

    public static void sort(Integer[] array) {
        int max = getMax(array);

        for (int place = 1; max / place > 0; place *= 10) {
            sort(array, place);
        }
    }

    private static int getMax(Integer[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++)
            if (max < array[i])
                max = array[i];
        return max;
    }

    private static void sort(Integer[] array, int place) {
        int[] output = new int[array.length];
        int[] count = new int[10];
        int i;

        for (i = 0; i < array.length; i++) {
            count[i] = 0;
        }

        for (i = 0; i < array.length; i++) {
            count[(array[i] / place) % 10]++;
        }


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = array.length - 1; i >= 0; i--)
        {
            output[count[ (array[i]/place)%10 ] - 1] = array[i];
            count[(array[i]/place)%10]--;
        }

        for (i = 0; i < array.length; i++)
            array[i] = output[i];
    }
}
