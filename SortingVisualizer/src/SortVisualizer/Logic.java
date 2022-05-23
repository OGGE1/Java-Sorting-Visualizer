package SortVisualizer;

import javax.swing.*;
import java.util.Random;

public class Logic {

    int[] lineArray;
    VisualizerPanel panel;

    public Logic(VisualizerPanel panel) {
        this.panel = panel;
        createArray();
    }

    public void createArray() {
        int[] tmp = new int[100];
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            tmp[i] = rand.nextInt(100) + 1;
        }
        lineArray = tmp;
    }

    public int[] getLineArray() {
        return lineArray;
    }
}
