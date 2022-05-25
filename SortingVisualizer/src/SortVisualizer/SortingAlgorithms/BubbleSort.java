package SortVisualizer.SortingAlgorithms;

import SortVisualizer.VisualizerPanel;

import java.util.concurrent.TimeUnit;

public class BubbleSort implements Runnable{

    private int[] lineArray;
    private VisualizerPanel panel;
    private Long timeStarted;

    public BubbleSort(int[] lineArray, VisualizerPanel panel) {
        this.lineArray = lineArray;
        this.panel = panel;
        timeStarted = System.nanoTime();
    }
    public void run() {
        sortSlow();
        double ms = TimeUnit.MILLISECONDS.convert(System.nanoTime() - timeStarted, TimeUnit.NANOSECONDS);
        System.out.println(ms / 1000);
    }

    public void sortSlow() {
        int temp = 0;
        boolean swapped = false;

        for(int i = 0; i<lineArray.length-1; i++){
            swapped = false;

            for(int j = 1; j<lineArray.length-i; j++){
                if (lineArray[j-1]> lineArray[j]){
                    temp = lineArray[j-1];
                    lineArray[j-1] = lineArray[j];
                    lineArray[j]= temp;
                    swapped = true;
                }

                panel.drawArray(lineArray);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            if (!swapped) break;
        }
    }
}
