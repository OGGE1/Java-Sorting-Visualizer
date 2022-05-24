package SortVisualizer.SortingAlgorithms;

import SortVisualizer.VisualizerPanel;

import java.util.concurrent.TimeUnit;

public class HeapSort implements Runnable {

    private int[] arr;
    private VisualizerPanel panel;
    private Long timeStarted;

    public HeapSort(int[] arr, VisualizerPanel panel) {
        this.arr = arr;
        this.panel = panel;
        timeStarted = System.nanoTime();
    }

    @Override
    public void run() {
        heapSort(arr);
        double ms = TimeUnit.MILLISECONDS.convert(System.nanoTime() - timeStarted, TimeUnit.NANOSECONDS);
        System.out.println(ms / 1000);
    }

    public void heapSort(int arr[]) {
        int temp;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {           //build the heap
            heapify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i > 0; i--) {                //extract elements from the heap
            temp = arr[0];                                        //move current root to end (since it is the largest)
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);                                //recall heapify to rebuild heap for the remaining elements
        }

    }

    void heapify(int arr[], int n, int i) {
        int MAX = i;                                             // Initialize largest as root
        int left = 2 * i + 1;                                    //index of the left child of ith node = 2*i + 1
        int right = 2 * i + 2;                                   //index of the right child of ith node  = 2*i + 2
        int temp;

        if (left < n && arr[left] > arr[MAX]) {                  //check if the left child of the root is larger than the root
            MAX = left;
        }

        if (right < n && arr[right] > arr[MAX]) {                //check if the right child of the root is larger than the root
            MAX = right;
        }

        if (MAX != i) {                                          //repeat the procedure for finding the largest element in the heap
            temp = arr[i];
            arr[i] = arr[MAX];
            arr[MAX] = temp;
            heapify(arr, n, MAX);
        }
        panel.drawArray(arr);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
