package SortVisualizer.SortingAlgorithms;

import SortVisualizer.VisualizerPanel;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oscar Norman <br>
 * Date: 5/25/2022   <br>
 * Time: 11:08 PM   <br>
 * Project: SortingVisualizer <br>
 */
// Java implementation of Counting Sort
public class RadixSort implements Runnable {

    private int[] arr;
    private VisualizerPanel panel;
    private Long timeStarted;
    private int sortingSpeed;

    public RadixSort(int[] arr, VisualizerPanel panel, int sortingSpeed) {
        this.arr = arr;
        this.panel = panel;
        this.sortingSpeed = sortingSpeed;
        this.timeStarted = System.nanoTime();
    }

    @Override
    public void run() {
        radixsort(arr, arr.length);
        double ms = TimeUnit.MILLISECONDS.convert(System.nanoTime() - timeStarted, TimeUnit.NANOSECONDS);
        System.out.println(ms / 1000);
    }

    // A utility function to get maximum value in arr[]
    public int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        panel.drawArray(arr);
        try {
            Thread.sleep(sortingSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        panel.drawArray(arr);
        try {
            Thread.sleep(sortingSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        panel.drawArray(arr);
        try {
            Thread.sleep(sortingSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }

        panel.drawArray(arr);
        try {
            Thread.sleep(sortingSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    public void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
            panel.drawArray(arr);
            try {
                Thread.sleep(sortingSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

