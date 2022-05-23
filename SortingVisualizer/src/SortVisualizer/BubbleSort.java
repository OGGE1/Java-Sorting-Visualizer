package SortVisualizer;

public class BubbleSort implements Runnable{

    private int[] lineArray;
    private VisualizerPanel panel;

    public BubbleSort(int[] lineArray, VisualizerPanel panel) {
        this.lineArray = lineArray;
        this.panel = panel;
    }
    public void run() {
        sortSlow();
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
