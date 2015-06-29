package Uni.AlDa;


import java.util.Arrays;

public class QuickSort {
    /** Array of int sortieren mittels QuickSort */
    public static void sort(int[] daten) {
        quicksort(daten, 0, daten.length - 1);
    }
    /** Teilarray of int sortieren mittels QuickSort */
    public static void quicksort(int[] daten, int start, int ende) {
        if (start >= ende) { return; } // Max 1 Element: fertig!

        // Divide at Pivot:
        final int pivot = daten[start]; // Pivot
        int links = start + 1, rechts = ende;
        while(true) {
            if (daten[links] > pivot && daten[rechts] < pivot) {
                SortUtil.vertausche(daten, links, rechts);
            }
            if (links < rechts) {
                if (daten[links] <= pivot){
                    links++;
                } else if (daten[rechts] > pivot){
                    rechts--;
                }
            } else {
                break;
            }
        }
        // Pivot an der RICHTIGEN Position einsetzen:
        SortUtil.vertausche(daten, start, links-1);

        // Conquer (kein Merge notwendig, wenn Pivot korrekt):
        quicksort(daten, start, rechts -2 );
        quicksort(daten, rechts + 1, ende);
    }

    public static void main(String[] args){
        int[] arr = new int[] {1,5,3,2,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}