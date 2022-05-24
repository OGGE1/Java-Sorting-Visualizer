package SortVisualizer.SortingAlgorithms;

import SortVisualizer.VisualizerPanel;

import java.util.concurrent.TimeUnit;

public class InsertionSort implements Runnable {

    private int[] arr;
    private VisualizerPanel panel;
    private Long timeStarted;

    public InsertionSort(int[] arr, VisualizerPanel panel) {
        this.arr = arr;
        this.panel = panel;
        this.timeStarted = System.nanoTime();
    }

    @Override
    public void run() {
        insertionSort(arr, arr.length);
        double ms = TimeUnit.MILLISECONDS.convert(System.nanoTime() - timeStarted, TimeUnit.NANOSECONDS);
        System.out.println(ms / 1000);
    }

    public void insertionSort(int arr[], int n)
    {
        if (n <= 1) {                               //passes are done
            return;
        }

        insertionSort( arr, n-1 );               //one element sorted, sort the remaining array

        int last = arr[n-1];                        //last element of the array
        int j = n-2;                                //correct index of last element of the array

        while (j >= 0 && arr[j] > last) {           //find the correct index of the last element

            arr[j+1] = arr[j];                      //shift section of sorted elements upwards by one element if correct index isn't found
            j--;
        }
        arr[j+1] = last;                            //set the last element at its correct index

        panel.drawArray(arr);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
