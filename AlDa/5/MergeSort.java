import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class MergeSort {

    /**
     * Array of int sortieren mittels MergeSort
     */
    public static void sort(int[] daten) {
        mergesort(daten, new int[daten.length], 0, daten.length - 1);
    }

    /**
     * Teilarray of int sortieren mittels MergeSort
     */
    public static void mergesort(int[] daten, int[] tmp, int start, int ende) {
        if (start >= ende) {
            return;
        } // Max 1 Element: fertig!

        // Divide:
        final int half = (start + ende) / 2;
        // Conquer:
        mergesort(daten, tmp, start, half);
        mergesort(daten, tmp, half + 1, ende);
        // Merge:
        int i = start, j = half + 1, k = start;
        while (i <= half && j <= ende) {
            if(daten[i] <= daten[j]){
                tmp[k] = daten[i];
                i++;
            } else {
                tmp[k] = daten[j];
                j++;
            }
            k++;
        }
        while (i <= half) { // Rechter Teil schon leer!
            tmp[k] = daten[i];
            i++;
            k++;

        }
        while (j <= ende) { // Linker Teil schon leer!
            tmp[k] = daten[j];
            j++;
            k++;
        }
        // aus tmp zurueck kopieren:
        for (int l = start; l < k; l++) {
            daten[l] = tmp[l];
        }
    }

    @Test
    public void test(){
        int[] data = new int [] {6,2,56,1,0,4,-21};

        int [] sorted = data.clone();
        Arrays.sort(sorted);

        sort(data);

        assertArrayEquals(data, sorted);

    }
}