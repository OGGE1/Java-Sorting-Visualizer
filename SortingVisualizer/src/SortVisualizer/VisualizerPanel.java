package SortVisualizer;

import SortVisualizer.SortingAlgorithms.BubbleSort;
import SortVisualizer.SortingAlgorithms.HeapSort;
import SortVisualizer.SortingAlgorithms.InsertionSort;
import SortVisualizer.SortingAlgorithms.MergeSort;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class VisualizerPanel extends JPanel {

    private GridBagLayout gl = new GridBagLayout();
    private GridBagConstraints gc = new GridBagConstraints();
    private JFrame frame;
    private Thread t;

    public VisualizerPanel(JFrame frame) throws IOException {
        this.frame = frame;
        this.setPreferredSize(new Dimension(1920, 980));
        this.setBackground(new Color(176, 230, 135));
        this.setDoubleBuffered(true);
        gc.insets = new Insets(0, 1, 0, 1);
        gc.anchor = GridBagConstraints.LAST_LINE_START;
        this.setLayout(gl);

    }

    public void drawArray(int[] arr) {
        this.removeAll();

        for (int i = 0 ; i < arr.length; i++) {
            JPanel tmp = new JPanel();
            tmp.setDoubleBuffered(true);
            tmp.setPreferredSize(new Dimension(5, arr[i] * 8));
            tmp.setBackground(Color.blue);
            this.add(tmp, gc);
        }
        this.repaint();
        this.revalidate();
        this.validate();
    }

    public void clearScreen() {
        this.removeAll();
        this.repaint();
        this.revalidate();
        this.validate();
    }
    public int[] createArray(int amount) {
        int[] tmp = new int[amount];
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            tmp[i] = rand.nextInt(100) + 1;
        }
        return tmp;
    }

    public void run(String type, int amount, int sortingSpeed) {
        if(type.equalsIgnoreCase("Bubble Sort"))
            t = new Thread(new BubbleSort(createArray(amount), this, sortingSpeed));
        if (type.equalsIgnoreCase("Merge Sort"))
            t = new Thread(new MergeSort(createArray(amount), this, sortingSpeed));
        if (type.equalsIgnoreCase("Heap Sort"))
            t = new Thread(new HeapSort(createArray(amount), this, sortingSpeed));
        if (type.equalsIgnoreCase("Insertion Sort"))
            t = new Thread(new InsertionSort(createArray(amount), this, sortingSpeed));

        t.start();
    }

    public void stopThread() {
        if (t != null)
            t.stop();
    }

}
