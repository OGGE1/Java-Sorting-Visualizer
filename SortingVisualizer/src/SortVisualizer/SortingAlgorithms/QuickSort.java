package SortVisualizer.SortingAlgorithms;

import SortVisualizer.VisualizerPanel;

import java.util.concurrent.TimeUnit;

/**
 * Created by Oscar Norman <br>
 * Date: 5/25/2022   <br>
 * Time: 10:50 PM   <br>
 * Project: SortingVisualizer <br>
 */
public class QuickSort implements Runnable {

    private int[] arr;
    private VisualizerPanel panel;
    private Long timeStarted;
    private int sortingSpeed;

    public QuickSort(int[] arr, VisualizerPanel panel, int sortingSpeed) {
        this.arr = arr;
        this.panel = panel;
        this.sortingSpeed = sortingSpeed;
        timeStarted = System.nanoTime();
    }

    @Override
    public void run() {
        quickSort(arr, 0, arr.length - 1);
        double ms = TimeUnit.MILLISECONDS.convert(System.nanoTime() - timeStarted, TimeUnit.NANOSECONDS);
        System.out.println(ms / 1000);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    public int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);

            panel.drawArray(arr);
            try {
                Thread.sleep(sortingSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
